package component.steps.config;


import com.hpdts.hello.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest({"server.port=8080", "management.port=0"})
public abstract class BaseSteps {

    protected Map<String, Object> dataContext = new HashMap<String, Object>();
    protected RestTemplate template = new TestRestTemplate();
    protected String baseUrl = "http://localhost:8080";

}
