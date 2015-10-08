package com.hpdts.hello.service;


import com.hpdts.hello.Application;
import com.hpdts.hello.domain.Bank;
import com.hpdts.hello.repository.BankRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class BankServiceTest {

   @Autowired
   private BankService bankService;

   @Autowired
   private BankRepository bankRepository;

   @Before
   public void setUp() throws Exception {
       bankRepository.deleteAll();
       Bank bank = new Bank();
       bank.setId("0001").setDescription("Banco Test");
       bankRepository.save(bank);
       bank = new Bank();
       bank.setId("0002").setDescription("Banco Penta");
       bankRepository.save(bank);
   }


   @Test
   public void shouldGetAllBanks(){
       List<Bank> banks = bankService.getAllBanks();
       assertThat(banks.size(), is(2));
       assertThat(banks.get(0).getId(),  is("0001"));
       assertThat(banks.get(1).getId(),  is("0002"));
   }
}
