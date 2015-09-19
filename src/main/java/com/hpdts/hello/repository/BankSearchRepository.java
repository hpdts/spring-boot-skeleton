package com.hpdts.hello.repository;


import com.hpdts.hello.domain.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankSearchRepository {

    @Autowired
    private MongoOperations mongoOperations;


    public List<Bank> getBankByDescription(String description) {
        Query query = new Query();
        query.addCriteria(Criteria.where("description").regex(description));
        return  mongoOperations.find(query, Bank.class);
    }

    public List<Bank> getBankBySortedByID() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.ASC, "id"));
        return mongoOperations.find(query, Bank.class);
    }
}
