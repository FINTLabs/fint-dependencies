package no.fint.dependencies

import org.hamcrest.CoreMatchers
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

class FintDependenciesControllerSpec extends Specification {
    private FintDependenciesController controller
    private FintDependencies fintDependencies
    private MockMvc mockMvc

    void setup() {
        fintDependencies = Mock(FintDependencies)
        controller = new FintDependenciesController(fintDependencies: fintDependencies)
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
    }

    def "Get FINT dependencies"() {
        when:
        def response = mockMvc.perform(get('/fint-dependencies'))

        then:
        1 * fintDependencies.get() >> [new FintDependency(group: 'no.fint', name: 'test', version: '1.0.0')]
        response.andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath('$[0].group').value(CoreMatchers.equalTo('no.fint')))
                .andExpect(jsonPath('$[0].name').value(CoreMatchers.equalTo('test')))
                .andExpect(jsonPath('$[0].version').value(CoreMatchers.equalTo('1.0.0')))
    }
}
