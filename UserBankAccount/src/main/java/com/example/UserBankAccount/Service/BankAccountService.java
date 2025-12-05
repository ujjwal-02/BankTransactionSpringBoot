package com.example.UserBankAccount.Service;

import com.example.UserBankAccount.Domain.BankAccount;
import com.example.UserBankAccount.Exception.AccountNumberNotExist;
import com.example.UserBankAccount.Exception.BankAccountAlreadyExistException;
import com.example.UserBankAccount.Exception.BankAccountNotFoundException;

import java.util.List;

public interface BankAccountService {
    public String addBank(BankAccount bankAccount, int userId) throws BankAccountAlreadyExistException;

    public String removeBankAccount(String AccountNumber) throws BankAccountNotFoundException;

    public BankAccount getBankAccountBasedOnBankAccountNumber(String AccountNumber) throws BankAccountNotFoundException, AccountNumberNotExist;

    public List<BankAccount> getAllAccountOfUserBasedOnUserId(int userId) throws  BankAccountNotFoundException;

    public List<BankAccount> getBankAccountBasedOnBankName(String bankName, int userId) throws  BankAccountNotFoundException;

    public List<BankAccount> getAllBankAccount() throws BankAccountNotFoundException;

    public BankAccount checkBalance(int userId, String AccountNumber) throws BankAccountNotFoundException;

    public String updateBankAccount(BankAccount bankAccount) throws BankAccountNotFoundException;
}
