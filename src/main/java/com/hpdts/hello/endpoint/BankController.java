package com.hpdts.hello.endpoint;

import com.hpdts.hello.domain.Bank;
import com.hpdts.hello.repository.BankRepository;
import com.hpdts.hello.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
public class BankController {

    @Autowired
    private BankRepository bankrepository;

    @RequestMapping("/banks, method = RequestMethod.GET")
    public List<Bank> getAllBanks() {
        List<Bank> banks = new ArrayList<Bank>();
        return Util.createListFromIterable(banks, bankrepository.findAll());
    }
}
