package com.example.bankingapp;

import com.example.bankingapp.model.Transaction;
import com.example.bankingapp.repository.TransactionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;

@SpringBootApplication
public class BankingAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}

}
