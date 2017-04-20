package no.fint.dependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dependencies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FintDependenciesController {

    @Autowired
    private FintDependencies fintDependencies;

    @GetMapping
    public List<Dependency> getAll() {
        return fintDependencies.getAll();
    }

    @GetMapping("/fint")
    public List<Dependency> getFintDependencies() {
        return fintDependencies.getFintDependencies();
    }

    @GetMapping("/outdated")
    public List<Dependency> getOutdated() {
        return fintDependencies.getOutdated();
    }

}
