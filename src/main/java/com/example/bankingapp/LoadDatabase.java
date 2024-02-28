package com.example.bankingapp;

import com.example.bankingapp.model.Transaction;
import com.example.bankingapp.model.User;
import com.example.bankingapp.repository.TransactionRepository;
import com.example.bankingapp.repository.UserRepository;
import com.example.bankingapp.util.JSONUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;


@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TransactionRepository repository, UserRepository userRepository) throws IOException, ParseException {
        FileReader file = new FileReader("C://YEPP/bankingapp-backend/src/main/java/com/example/bankingapp/resources/DUMMY_TRANSACTIONS.json");
        FileReader fileUsers = new FileReader("C://YEPP/bankingapp-backend/src/main/java/com/example/bankingapp/resources/DUMMY_USERS.json");
        ArrayList<JSONObject> json = JSONUtil.fromJSONToArrayList(file);
        ArrayList<JSONObject> jsonUsers = JSONUtil.fromJSONToArrayList(fileUsers);
//        userRepository.save(new User(jsonUsers.get(0)));

        return args -> {
            json.forEach(transaction -> log.info("Preloading: " + repository.save(new Transaction(transaction))));
        };
    }


}