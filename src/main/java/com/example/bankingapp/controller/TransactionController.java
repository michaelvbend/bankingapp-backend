package com.example.bankingapp.controller;

import com.example.bankingapp.dto.UserDto;
import com.example.bankingapp.exceptions.TransactionNotFoundError;
import com.example.bankingapp.model.Transaction;
import com.example.bankingapp.service.TransactionService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }
    //Get all transactions

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public Iterable<Transaction> getAllTransactions(Principal principal){
//        UserDto user = principal.getName();
        return this.transactionService.getAllTransactions();
    }

//    Get single transaction by ID
    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET, params = "id")
    public Transaction getSingleTransaction(@PathVariable(value = "id") Long id) {
        return this.transactionService.getSingleTransaction(id);
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public void postNewTransaction(@RequestBody Transaction transaction){
        System.out.println(transaction);
        this.transactionService.saveTransaction(transaction);
    }
}
