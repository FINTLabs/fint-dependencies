package no.fint.dependencies

import spock.lang.Specification

class FintDependenciesSpec extends Specification {
    private FintDependencies fintDependencies

    void setup() {
        fintDependencies = new FintDependencies(
                reportFile: 'report.json',
                jsonPathCurrent: '$.current.dependencies',
                jsonPathOutdated: '$.outdated.dependencies')
        fintDependencies.init()
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

    def "Return empty list when report file is not found"() {
        given:
        def fintDeps = new FintDependencies(reportFile: 'unknown-file')

        when:
        fintDeps.init()
        def dependencies = fintDeps.getAll()

        then:
        dependencies.size() == 0
    }

}
