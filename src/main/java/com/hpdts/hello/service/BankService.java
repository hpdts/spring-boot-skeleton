package com.hpdts.hello.service;


import com.hpdts.hello.domain.Bank;
import com.hpdts.hello.exceptions.BankSaveException;
import com.hpdts.hello.repository.BankRepository;
import com.hpdts.hello.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankService {

    @Autowired
    private BankRepository bankrepository;

    public List<Bank> getAllBanks() {
        List<Bank> banks = new ArrayList<Bank>();
        return Util.createListFromIterable(banks, bankrepository.findAll());
    }

    public Bank saveBank(Bank bank) {
        Bank bankSaved;
        try{
             bankSaved = bankrepository.save(bank);
        }catch(Exception exception){
            throw new BankSaveException(exception);
        }
        if(bankSaved == null){
            throw new BankSaveException();
        }else{
            return bankSaved;
        }
    }


}
