package no.fint.dependencies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FintDependenciesConfig {

    @Bean
    public FintDependencies fintDependencies() {
        return new FintDependencies();
    }

    @Bean
    public FintDependenciesController fintDependenciesController() {
        return new FintDependenciesController();
    }

}
