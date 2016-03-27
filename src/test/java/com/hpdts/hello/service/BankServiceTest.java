package com.hpdts.hello.service;


import com.hpdts.hello.Application;
import com.hpdts.hello.domain.Bank;
import com.hpdts.hello.setup.SetupMongoTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class BankServiceTest extends SetupMongoTest {

   @Autowired
   private BankService bankService;


   @Before
   public void setUp() throws Exception {
       bankRepositoryInitialLoad();
   }


   @Test
   public void shouldGetAllBanks(){
       List<Bank> banks = bankService.getAllBanks();
       assertThat(banks.size(), is(2));
       assertThat(banks.get(0).getId(),  is("0001"));
       assertThat(banks.get(1).getId(), is("0002"));
   }

    @Test
    public void shouldSaveBanks(){
        Bank bank = new Bank().setId("BLNY").setDescription("BANK LEUMI NY");

        Bank bankSaved = bankService.saveBank(bank);
        assertNotNull(bankSaved);
        assertThat(bankSaved.getId(), is("BLNY"));

        List<Bank> banks = bankService.getAllBanks();
        assertThat(banks.size(), is(3));
        assertThat(banks.get(2).getId(),  is("BLNY"));
    }
}
