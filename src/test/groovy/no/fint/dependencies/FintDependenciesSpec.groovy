package no.fint.dependencies

import spock.lang.Specification

class FintDependenciesSpec extends Specification {
    private FintDependencies fintDependencies

    void setup() {
        fintDependencies = new FintDependencies()
    }

    def "Get all FINT dependencies"() {
        when:
        def dependencies = fintDependencies.get()

        then:
        dependencies.size() == 4
        dependencies[0].name == 'fint-event-model'
        dependencies[1].name == 'fint-administrasjon-model-java'
        dependencies[2].name == 'fint-relation-model'
        dependencies[3].name == 'fint-felles-model-java'
    }
}
