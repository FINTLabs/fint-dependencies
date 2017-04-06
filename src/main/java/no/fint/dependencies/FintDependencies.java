package no.fint.dependencies;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class FintDependencies {
    private Set<FintDependency> dependencies = new HashSet<>();

    public FintDependencies() {
        List<String> lines = readDependenciesFile();
        dependencies = lines.stream().filter(line -> line.contains("no.fint")).map(dependency -> {
            int startIndex = dependency.indexOf("no.fint");
            String[] parts = dependency.substring(startIndex, dependency.length()).split(":");
            String group = parts[0];
            String name = parts[1];
            String version = parts[2];
            return new FintDependency(group, name, version);
        }).collect(Collectors.toSet());
    }

    private List<String> readDependenciesFile() {
        List<String> lines = Collections.emptyList();
        try {
            InputStream inputStream = FintDependencies.class.getResourceAsStream("/dependencies.txt");
            if (inputStream != null) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                    lines = reader.lines().collect(Collectors.toList());
                }
            }
        } catch (IOException e) {
            log.warn("Exception when reading the dependencies.txt file on classpath");
        }
        return lines;
    }

    public Set<FintDependency> get() {
        return dependencies;
    }
}
