package com.hpdts.hello.exceptions;


public class BankSaveException extends RuntimeException{

    public BankSaveException(Exception exception) {
        super(exception);
    }

    public BankSaveException() {
        super();
    }
}
