package component.steps.repository;

import com.hpdts.hello.domain.Bank;
import com.hpdts.hello.repository.BankRepository;
import com.hpdts.hello.repository.BankSearchRepository;
import component.steps.config.BaseSteps;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;


public class BankSteps extends BaseSteps {

    @Autowired
    private BankRepository bankrepository;
    @Autowired
    private BankSearchRepository bankSearch;


    @Before
    public void beforeAll() {
        bankrepository.deleteAll();
    }

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
        List<Bank> banks = new ArrayList<Bank>();
        banks = createListFromIterable(banks, bankrepository.findAll());
        dataContext.put("banks", banks);
    }

    @Then("^I should have (\\d+) banks$")
    public void I_should_have_banks(int numberOfBanks) throws Throwable {
        List<Bank> banks = (List) dataContext.get("banks");
        assertThat(banks.size(), is(numberOfBanks));
    }

    public static List<Bank> createListFromIterable(List<Bank> banks, Iterable<Bank> iterator) {
        for (Bank bank : iterator) {
            banks.add(bank);
        }
        return banks;
    }

    @And("^page size is (\\d+)$")
    public void page_size_is(int pageSize) throws Throwable {
        dataContext.put("pageSize", pageSize);
    }

    @When("^I get bank page number (\\d+)$")
    public void I_get_bank_page_number(int pageNumber) throws Throwable {
        List<Bank> banks = new ArrayList<Bank>();
        Integer pageSize = (Integer) dataContext.get("pageSize");
        banks = createListFromIterable(banks, bankrepository.findAll(new PageRequest(pageNumber, pageSize)));
        dataContext.put("banks", banks);
    }

    @And("^one bank should (be|not be) (\\w+)$")
    public void one_bank_should_be(String beNotBe, String bankId) throws Throwable {
        List<Bank> banks = (List) dataContext.get("banks");
        Integer pageSize = (Integer) dataContext.get("pageSize");
        assertThat(banks.size(), is(pageSize));
        if(beNotBe.equals("be")){
            assertTrue(searchBank(banks, bankId));
        }else{
            assertFalse(searchBank(banks, bankId));
        }
    }

    private boolean searchBank(List<Bank> banks, String bankId) {
        for(Bank bank : banks){
            if(bank.getId().equals(bankId)){
                return true;
            }
        }
        return false;
    }

    @When("^I search by bank with (\\w+)$")
    public void I_search_bank_by_description(String description) throws Throwable {
        List<Bank> banks = bankSearch.getBankByDescription(description);
        dataContext.put("banks", banks);
    }

    @And("^I should have bank description as \\\"([^\\\"]*)\\\"$")
    public void I_should_have_bank_description_as(String description) throws Throwable {
        List<Bank> banks = (List) dataContext.get("banks");
        assertThat(banks.get(0).getDescription(), is(description));
    }

    @When("^I get all the banks sorted by id$")
    public void I_get_all_the_banks_sorted_by_id() throws Throwable {
        List<Bank> banks = bankSearch.getBankBySortedByID();
        dataContext.put("banks", banks);
    }

    @And("^the first one is (\\w+)$")
    public void the_first_one_is(String id) throws Throwable {
        List<Bank> banks = (List) dataContext.get("banks");
        assertThat(banks.get(0).getId(), is(id));
    }
}