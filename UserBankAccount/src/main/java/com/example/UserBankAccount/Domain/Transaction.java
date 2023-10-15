package com.example.UserBankAccount.Domain;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Date;

@Document(collection = "TransactionCollection")
public class Transaction {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private int transactionId;
    private String accountNumberUser1;
    private int userId;

    private String accountNumberUser2;
    private double transactionAmount;
    private String transactionType;

    private String description;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedDate
    private Date createdAt1;

    @LastModifiedDate
    private Date updatedAt1;

    public Transaction() {
    }

    public Transaction(int transactionId, String accountNumberUser1, int userId, String accountNumberUser2, double transactionAmount, String transactionType, String description) {
        this.transactionId = transactionId;
        this.accountNumberUser1 = accountNumberUser1;
        this.userId = userId;
        this.accountNumberUser2 = accountNumberUser2;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.description = description;

    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountNumberUser1() {
        return accountNumberUser1;
    }

    public void setAccountNumberUser1(String accountNumberUser1) {
        this.accountNumberUser1 = accountNumberUser1;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountNumberUser2() {
        return accountNumberUser2;
    }

    public void setAccountNumberUser2(String accountNumberUser2) {
        this.accountNumberUser2 = accountNumberUser2;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt1() {
        return createdAt1;
    }

    public void setCreatedAt1(Date createdAt1) {
        this.createdAt1 = createdAt1;
    }

    public Date getUpdatedAt1() {
        return updatedAt1;
    }

    public void setUpdatedAt1(Date updatedAt1) {
        this.updatedAt1 = updatedAt1;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", accountNumberUser1='" + accountNumberUser1 + '\'' +
                ", userId=" + userId +
                ", accountNumberUser2='" + accountNumberUser2 + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", transactionType='" + transactionType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
