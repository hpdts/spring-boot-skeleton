package com.hpdts.config;


import java.util.HashMap;
import java.util.Map;

/*@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTest
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration*/
public abstract class BaseIntegration {

   // protected String base = "http://localhost:8080";
   // protected RestTemplate template = new TestRestTemplate();
    protected Map<String, Object> dataContext = new HashMap<String, Object>();


}
