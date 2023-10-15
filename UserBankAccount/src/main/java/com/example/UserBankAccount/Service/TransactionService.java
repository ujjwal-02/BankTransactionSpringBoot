package com.example.UserBankAccount.Service;

import com.example.UserBankAccount.Domain.Transaction;
import com.example.UserBankAccount.Exception.BankAccountNotFoundException;
import com.example.UserBankAccount.Exception.InsufficientBalanceException;
import com.example.UserBankAccount.Exception.ReciverBankAccountNotFound;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {

    public String transferAmount(int userId, Transaction transaction) throws  BankAccountNotFoundException, InsufficientBalanceException, ReciverBankAccountNotFound;

    public List<Transaction> bankStatement(int userId, String accountNumber) throws BankAccountNotFoundException;

    public List<Transaction> bankStatementOfUser(int userId) ;

    public List<Transaction> transactionHistoryForBankAccount(int userId, String accountNumber) ;

    public List<Transaction> getTransactionBYDate(int userId, LocalDate ld);
}
