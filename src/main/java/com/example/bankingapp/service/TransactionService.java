package com.example.bankingapp.service;

import com.example.bankingapp.model.Transaction;
import com.example.bankingapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.bankingapp.exceptions.TransactionNotFoundError;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Iterable<Transaction> getAllTransactions() {
        Iterable<Transaction> listOfTransactions = this.transactionRepository.findAll(Sort.by("date"));
        return listOfTransactions;
    }
    public Transaction getSingleTransaction(Long id){
        Transaction transaction = this.transactionRepository.findById(id).orElseThrow(() ->
            new TransactionNotFoundError(id));
        return transaction;
    };

    public void saveTransaction(Transaction transaction){
        this.transactionRepository.save(transaction);
    }
}
