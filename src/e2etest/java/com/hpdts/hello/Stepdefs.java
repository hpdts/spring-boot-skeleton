package com.hpdts.hello;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:8080")
public class Stepdefs {

    //protected Map<String, Object> dataContext = new HashMap<String, Object>();
	//@Autowired
    //private WebApplicationContext context;
    RestTemplate template = new TestRestTemplate();

	//@Before
	//public void setup() throws IOException {
		//MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	//}

    @When("^my application is running$")
    public void i_go_to_the_hello_page() throws Throwable {
        ResponseEntity<String> response = template.getForEntity("http://localhost:8080", String.class);
       // dataContext.put("response", response);
    }

    @When("^I hit hello controller$")
    public void I_hit_hello_controller() throws Throwable {

    }

    @Then("^I get a (\\d+)$")
    public void I_get_a(int arg1) throws Throwable {
        //assertThat(((ResponseEntity<String>) dataContext.get("response")).getBody(), is("Greetings from Spring Boot!"));
    }

    @And("^I see \"([^\"]*)\" as a message from the controller$")
    public void I_see_as_a_message_from_the_controller(String arg1) throws Throwable {

    }
}
