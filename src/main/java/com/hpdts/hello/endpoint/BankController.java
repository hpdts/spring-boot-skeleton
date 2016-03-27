package com.hpdts.hello.endpoint;

import com.hpdts.hello.domain.Bank;
import com.hpdts.hello.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value="/save-banks", method = RequestMethod.POST)
    public ResponseEntity<?> saveBanks(@ModelAttribute("bank") Bank bank) {
        try {
            return new ResponseEntity<Bank>(bankService.saveBank(bank), HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<String>("An error occurred saving bank. Message: " + exception.getMessage() +
                    ", cause: " + exception.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
