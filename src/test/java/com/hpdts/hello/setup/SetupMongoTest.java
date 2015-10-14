package com.hpdts.hello.setup;


import com.hpdts.hello.domain.Bank;
import com.hpdts.hello.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SetupMongoTest {

    @Autowired
    private BankRepository bankRepository;

    protected void bankRepositoryInitialLoad(){
        bankRepository.deleteAll();
        Bank bank = new Bank();
        bank.setId("0001").setDescription("Banco Test");
        bankRepository.save(bank);
        bank = new Bank();
        bank.setId("0002").setDescription("Banco Penta");
        bankRepository.save(bank);
    }
}
