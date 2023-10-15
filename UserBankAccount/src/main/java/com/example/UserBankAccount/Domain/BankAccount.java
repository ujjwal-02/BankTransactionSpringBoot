package com.example.UserBankAccount.Domain;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//import java.util.Date;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Document(collection = "BankCollection")
public class BankAccount {


    private int userId;
    private String bankName;
    private String branchName;

//    private String accountId;

    @Id
    private String accountNumber;
    private String accountType;
    private String ifscCode;

    private double bankBalance;

    private List<Integer> transactionId;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;




    public BankAccount() {
    }

    public BankAccount(int userId, String bankName, String branchName, String accountNumber, String accountType, String ifscCode, double bankBalance, List<Integer> transactionId, Date createdAt, Date updatedAt) {
        this.userId = userId;
        this.bankName = bankName;
        this.branchName = branchName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.ifscCode = ifscCode;
        this.bankBalance = bankBalance;
        this.transactionId = transactionId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public List<Integer> getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(List<Integer> transactionId) {
        this.transactionId = transactionId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "userId=" + userId +
                ", bankName='" + bankName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", AccountType='" + accountType + '\'' +
                ", IFSCCode='" + ifscCode + '\'' +
                ", bankBalance=" + bankBalance +
                ", transactionId=" + transactionId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
