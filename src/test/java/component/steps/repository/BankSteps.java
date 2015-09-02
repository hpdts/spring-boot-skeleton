package component.steps.repository;

import com.hpdts.hello.domain.Bank;
import com.hpdts.hello.repository.BankRepository;
import component.steps.config.BaseSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;


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
        dataContext.put("banks", banks);
    }

    @Then("^I should have (\\d+) banks$")
    public void I_should_have_banks(int numberOfBanks) throws Throwable {
        List<Bank> banks = (List) dataContext.get("banks");
        assertThat(banks.size(), is(numberOfBanks));
    }
}