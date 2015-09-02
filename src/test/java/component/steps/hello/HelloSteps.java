package component.steps.hello;

import component.steps.config.BaseSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;


public class HelloSteps extends BaseSteps {

    @Given("^my application is running$")
    public void i_go_to_the_hello_page() {
    }

    @When("^I hit hello controller$")
    public void I_hit_hello_controller(){
        ResponseEntity<String> response = template.getForEntity(baseUrl, String.class);
        dataContext.put("response", response);
    }

    @Then("^I get a (\\d+)$")
    public void I_get_a(int statusCode) {
        ResponseEntity<String> response = (ResponseEntity<String>) dataContext.get("response");
        assertThat(response.getStatusCode().value(), is(statusCode));
    }

    @And("^I see (.*) as a message from the controller$")
    public void I_see_as_a_message_from_the_controller(String message){
        ResponseEntity<String> response = (ResponseEntity<String>) dataContext.get("response");
        assertThat(response.getBody(), is(message));
    }
}
