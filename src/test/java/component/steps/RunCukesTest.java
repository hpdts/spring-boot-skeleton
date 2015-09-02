package component.steps;


import cucumber.api.CucumberOptions;
import cucumber.api.Pending;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = "pretty", features = "src/e2etest/resources/")
@Pending
public class RunCukesTest {
}
