package com.hpdts.hello.repository;

import com.hpdts.hello.domain.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface BankRepository extends MongoRepository<Bank, String> {


}
