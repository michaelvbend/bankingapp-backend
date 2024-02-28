package com.example.bankingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.json.simple.JSONObject;

import java.math.BigDecimal;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;

    private String date;
    private String fromIBAN;
    private String toIBAN;
    private int accountId;
    private String title;
    private String description;
    private BigDecimal amount;
    private String category;

    protected Transaction() {}

    public Transaction(JSONObject transaction) {
        this.date = transaction.get("date").toString();
        this.fromIBAN = transaction.get("fromIBAN").toString();;
        this.toIBAN = transaction.get("toIBAN").toString();
        this.accountId = Integer.parseInt(transaction.get("accountId").toString());
        this.title = transaction.get("title").toString();
        this.description = transaction.get("description").toString();
        this.amount = BigDecimal.valueOf(Double.parseDouble(transaction.get("amount").toString()));
        this.category = transaction.get("category").toString();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFromIBAN() {
        return fromIBAN;
    }

    public void setFromIBAN(String fromIBAN) {
        this.fromIBAN = fromIBAN;
    }

    public String getToIBAN() {
        return toIBAN;
    }

    public void setToIBAN(String toIBAN) {
        this.toIBAN = toIBAN;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Transaction(String date, String fromIBAN, String toIBAN, int accountId, String title, String description, BigDecimal amount, String category) {
        this.date = date;
        this.fromIBAN = fromIBAN;
        this.toIBAN = toIBAN;
        this.accountId = accountId;
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", fromIBAN='" + fromIBAN + '\'' +
                ", toIBAN='" + toIBAN + '\'' +
                ", accountId=" + accountId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                '}';
    }
}
