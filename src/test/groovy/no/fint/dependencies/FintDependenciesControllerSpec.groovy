package no.fint.dependencies

import com.github.spock.spring.utils.MockMvcSpecification
import org.springframework.test.web.servlet.MockMvc

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.Matchers.hasSize
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE

class FintDependenciesControllerSpec extends MockMvcSpecification {
    private FintDependenciesController controller
    private FintDependencies fintDependencies
    private MockMvc mockMvc

    void setup() {
        fintDependencies = Mock(FintDependencies)
        controller = new FintDependenciesController(fintDependencies: fintDependencies)
        mockMvc = standaloneSetup(controller)
    }

    def "Get all dependencies"() {
        when:
        def response = mockMvc.perform(get('/dependencies'))

        then:
        1 * fintDependencies.getAll() >> [
                new Dependency(group: 'com.test', name: 'test1', version: '1.0.0'),
                new Dependency(group: 'com.test', name: 'test2', version: '1.0.0')
        ]
        response.andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath('$', hasSize(2)))
                .andExpect(jsonPath('$[0].group').value(equalTo('com.test')))
                .andExpect(jsonPath('$[0].name').value(equalTo('test1')))
                .andExpect(jsonPath('$[0].version').value(equalTo('1.0.0')))
    }

    def "Get FINT dependencies"() {
        when:
        def response = mockMvc.perform(get('/dependencies/fint'))

        then:
        1 * fintDependencies.getFintDependencies() >> [new Dependency(group: 'no.fint', name: 'test', version: '1.0.0')]
        response.andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath('$', hasSize(1)))
                .andExpect(jsonPath('$[0].group').value(equalTo('no.fint')))
                .andExpect(jsonPath('$[0].name').value(equalTo('test')))
                .andExpect(jsonPath('$[0].version').value(equalTo('1.0.0')))
    }

    def "Get outdated dependencies"() {
        when:
        def response = mockMvc.perform(get('/dependencies/outdated'))

        then:
        1 * fintDependencies.getOutdated() >> [
                new Dependency(group: 'com.test', name: 'test1', version: '1.0.0')
        ]
        response.andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath('$', hasSize(1)))
                .andExpect(jsonPath('$[0].group').value(equalTo('com.test')))
                .andExpect(jsonPath('$[0].name').value(equalTo('test1')))
                .andExpect(jsonPath('$[0].version').value(equalTo('1.0.0')))
    }
}
