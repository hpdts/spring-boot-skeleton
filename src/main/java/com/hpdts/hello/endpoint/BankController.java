package com.hpdts.hello.endpoint;

import com.hpdts.hello.domain.Bank;
import com.hpdts.hello.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    private BankService bankService;


    @RequestMapping("/banks")
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }
}
