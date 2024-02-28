package com.example.bankingapp;

import com.example.bankingapp.model.Transaction;
import com.example.bankingapp.model.User;
import com.example.bankingapp.repository.TransactionRepository;
import com.example.bankingapp.repository.UserRepository;
import com.example.bankingapp.util.JSONUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase(TransactionRepository repository, UserRepository userRepository) {
        return args -> {
            try {
                List<Transaction> transactions = readTransactionsFromFile("C://YEPP/bankingapp-backend/src/main/java/com/example/bankingapp/resources/DUMMY_TRANSACTIONS.json");
                List<User> users = readUsersFromFile("C://YEPP/bankingapp-backend/src/main/java/com/example/bankingapp/resources/DUMMY_USERS.json");

                transactions.forEach(transaction -> log.info("Preloading transaction: " + repository.save(transaction)));
                users.forEach(user -> log.info("Preloading user: " + userRepository.save(user)));
            } catch (IOException e) {
                log.error("Error reading data from files: " + e.getMessage());
            }
        };
    }

    private List<Transaction> readTransactionsFromFile(String filePath) throws IOException {
        return Files.lines(Path.of(filePath))
                .map(JSONUtil::fromJSONToTransaction)
                .collect(Collectors.toList());
    }

    private List<User> readUsersFromFile(String filePath) throws IOException {
        return Files.lines(Path.of(filePath))
                .map(JSONUtil::fromJSONToUser)
                .collect(Collectors.toList());
    }

    private User fromJSONToUser(JSONObject jsonObject) {
        String userName = jsonObject.get("userName").toString();
        String password = jsonObject.get("password").toString();
        return User.builder().userName("test")
                .password(passwordEncoder.encode("test"))
                .build();
    }
}
