package com.hpdts.hello.endpoint;

import com.hpdts.hello.domain.Bank;
import com.hpdts.hello.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BankController {

    @Autowired
    private BankService bankService;


    @RequestMapping("/banks")
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }

    @RequestMapping(value="/save-banks", method = RequestMethod.POST)
    public ResponseEntity<?> saveBanks(@RequestBody Bank bank) {
        try {
            log.info("Bank to save: " + bank.getId() + "," + bank.getDescription());
            return new ResponseEntity<Bank>(bankService.saveBank(bank), HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<String>("An error occurred saving bank. Message: " + exception.getMessage() +
                    ", cause: " + exception.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/get-bank-by-id", method = RequestMethod.GET)
    public ResponseEntity<?> getBankById(@RequestParam("id") String id) {
        try {
            return new ResponseEntity<Bank>(bankService.getBankById(id), HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<String>("An error occurred getting bank by Id. Message: " + exception.getMessage() +
                    ", cause: " + exception.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/delete-bank", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBank(@RequestParam("id") String id) {
        try {
            bankService.removeBankById(id);
            return new ResponseEntity<String>("Bank id " + id + " removed successfully", HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<String>("An error occurred getting bank by Id. Message: " + exception.getMessage() +
                    ", cause: " + exception.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
