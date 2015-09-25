package com.hpdts.hello.utils;


import com.hpdts.hello.domain.Bank;

import java.util.List;

public class Util {

    public static List<Bank> createListFromIterable(List<Bank> banks, Iterable<Bank> iterator) {
        for (Bank bank : iterator) {
            banks.add(bank);
        }
        return banks;
    }
}
