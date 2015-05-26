package com.hpdts.hello;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class helloSteps {

    @Given("^my application is running$")
    public void my_application_is_running(){

    }

    @When("^I hit hello controller$")
    public void I_hit_hello_controller() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I get a (\\d+)$")
    public void I_get_a(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^I see (\\w) as a message from the controller$")
    public void I_see_as_a_message_from_the_controller(String messsage) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
