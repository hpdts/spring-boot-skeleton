package com.hpdts.hello.repository;

import com.hpdts.hello.domain.Bank;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankRepository extends PagingAndSortingRepository<Bank, String> {


}
