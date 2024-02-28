package com.example.bankingapp.exceptions;
public class TransactionNotFoundError extends RuntimeException {

    public TransactionNotFoundError(Long id) {
        super("Could not find transaction " + id);
    }
}
