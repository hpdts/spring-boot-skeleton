package com.hpdts.hello.endpoint;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class BankControllerTest {

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new BankController()).build();
	}

	@Test
	public void getBanks() throws Exception {
	/*	mvc.perform(MockMvcRequestBuilders.get("/banks").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
                .andExpect((jsonPath("$.data.roles", Matchers.hasSize(2))));*/
	}
}