package no.fint.dependencies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"version"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dependency {
    private String group;
    private String name;
    private String version;
}
