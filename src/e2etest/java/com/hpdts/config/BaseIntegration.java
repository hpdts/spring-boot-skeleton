package com.hpdts.config;


import com.hpdts.hello.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class BaseIntegration {

    private String base;
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = "http://localhost:8080";
        template = new TestRestTemplate();
    }

    @Test
    public void testRequest() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base, String.class);
        assertThat(response.getBody(), is("Greetings from Spring Boot!"));
    }

}
