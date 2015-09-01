package component.steps.repository;

import com.hpdts.hello.domain.Bank;
import com.hpdts.hello.repository.BankRepository;
import com.hpdts.hello.repository.CustomerRepository;
import component.steps.base.BaseSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;


public class BankSteps extends BaseSteps {

    @Autowired
    private BankRepository bankrepository;


    @Given("^I have the following banks$")
    public void I_have_the_following_banks(List<Map<String, String>> table) throws Throwable {

        for (Map<String, String> row : table) {
            Bank bank = new Bank();
            bank.setId(row.get("id")).setDescription(row.get("description"));
            bankrepository.save(bank);
        }

    }

    @When("^I get all the banks$")
    public void I_get_all_the_banks() throws Throwable {

        List<Bank> banks = bankrepository.findAll();




    }

    @Then("^I should have (\\d+) banks$")
    public void I_should_have_banks(int data) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}