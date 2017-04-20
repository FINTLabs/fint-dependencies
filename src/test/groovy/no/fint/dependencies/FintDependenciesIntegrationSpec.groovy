package no.fint.dependencies

import no.fint.dependencies.testutils.TestApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(classes = TestApplication, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class FintDependenciesIntegrationSpec extends Specification {

    @Autowired
    private FintDependencies fintDependencies

    @Autowired
    private FintDependenciesController fintDependenciesController

    def "Verify FintDependencies config"() {
        when:
        def dependencies = fintDependencies.getAll()

        then:
        dependencies.size() == 17
    }

    def "Verify FintDependenciesController config"() {
        when:
        def dependencies = fintDependenciesController.getAll()

        then:
        dependencies.size() == 17
    }

}
