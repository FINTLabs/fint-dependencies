package no.fint.dependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/fint-dependencies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FintDependenciesController {

    @Autowired
    private FintDependencies fintDependencies;

    @RequestMapping(method = RequestMethod.GET)
    public Set<FintDependency> getDependencies() {
        return fintDependencies.get();
    }

}
