package no.fint.dependencies

import spock.lang.Specification

class FintDependenciesSpec extends Specification {
    private FintDependencies fintDependencies

    void setup() {
        fintDependencies = new FintDependencies()
    }

    def "Get all dependencies"() {
        when:
        def dependencies = fintDependencies.getAll()

        then:
        dependencies.size() == 17
    }

    def "Get all FINT dependencies"() {
        when:
        def dependencies = fintDependencies.getFintDependencies()

        then:
        dependencies.size() == 7
        dependencies.each {
            assert it.name.startsWith('fint-')
        }
    }

    def "Get all outdated dependencies"() {
        when:
        def dependencies = fintDependencies.getOutdated()

        then:
        dependencies.size() == 4
    }

}
