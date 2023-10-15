package com.example.UserBankAccount.Controller;

import com.example.UserBankAccount.Domain.BankAccount;
import com.example.UserBankAccount.Domain.Transaction;
import com.example.UserBankAccount.Exception.*;
import com.example.UserBankAccount.Service.BankAccountServiceImplementation;
import com.example.UserBankAccount.Service.TransactionServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankaccount")
public class BankAccountController {



    @Autowired
    BankAccountServiceImplementation bankAccountServiceImplementation;

    @PostMapping("/addbankaccount/{userId}")
    public ResponseEntity<?> addBankAccount(@RequestBody BankAccount bankAccount, @PathVariable int userId) throws  BankAccountAlreadyExistException {
        String s = bankAccountServiceImplementation.addBank(bankAccount,userId);
//        System.out.println(bankAccount);
        return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deletebankaccount/{accountNumber}")
    public ResponseEntity<?> deleteBankAccount(@PathVariable String accountNumber) throws BankAccountNotFoundException {
        String s = bankAccountServiceImplementation.removeBankAccount(accountNumber);
        return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getbankaccountbasedonaccountnumber/{accountNumber}")
    public ResponseEntity<?> getBankAccountBasedOnAccountNumber(@PathVariable String accountNumber) throws AccountNumberNotExist, BankAccountNotFoundException {
        BankAccount bankAccount = bankAccountServiceImplementation.getBankAccountBasedOnBankAccountNumber(accountNumber);
        return new ResponseEntity<>(bankAccount,HttpStatus.ACCEPTED);
    }
    @GetMapping("/getbankaccountlistbasedonuserid/{userId}")
    public ResponseEntity<?> getBankAccountBasedOnUserId(@PathVariable int userId) throws  BankAccountNotFoundException {
        List<BankAccount> bankAccountList = bankAccountServiceImplementation.getAllAccountOfUserBasedOnUserId(userId);
        return new ResponseEntity<>(bankAccountList, HttpStatus.ACCEPTED);
    }
    @GetMapping("/getbankaccountbasedonbankname/{userId}/{bankName}")
    public ResponseEntity<?> getBankAccountBasedOnBankName(@PathVariable String bankName, @PathVariable int userId) throws  BankAccountNotFoundException {
        List<BankAccount> bankAccountList = bankAccountServiceImplementation.getBankAccountBasedOnBankName(bankName,userId);
        return new ResponseEntity<>(bankAccountList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getallbankaccount")
    public ResponseEntity<?> getAllBankAccount() throws BankAccountNotFoundException {
        List<BankAccount> bankAccountList = bankAccountServiceImplementation.getAllBankAccount();
        return new ResponseEntity<>(bankAccountList,HttpStatus.ACCEPTED);
    }
    @GetMapping("/checkbalance/{userId}/{accountNumber}")
    public ResponseEntity<?> checkBalance(@PathVariable String accountNumber, @PathVariable int userId) throws  BankAccountNotFoundException {
        BankAccount bankAccount = bankAccountServiceImplementation.checkBalance(userId, accountNumber);
        return new ResponseEntity<>(bankAccount, HttpStatus.ACCEPTED);
    }

    @GetMapping("/updateBankAccount")
    public ResponseEntity<?> updateBankAccount(@RequestBody BankAccount bankAccount) throws BankAccountNotFoundException {
        String s = bankAccountServiceImplementation.updateBankAccount(bankAccount);
        return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
    }

    @Autowired
    TransactionServiceImplementation transactionServiceImplementation;

    @PostMapping("/transfermoney/{userId}")
    public ResponseEntity<?> transferAmount(@PathVariable int userId, @RequestBody Transaction transaction) throws BankAccountNotFoundException, InsufficientBalanceException, ReciverBankAccountNotFound {
        String s = transactionServiceImplementation.transferAmount(userId,transaction);
        return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
    }
    @GetMapping("/bankstatement/{userId}/{accountNumber}")
    public ResponseEntity<?> bankStatement(@PathVariable int userId, @PathVariable String accountNumber) throws BankAccountNotFoundException {
        List<Transaction> transactionList = transactionServiceImplementation.bankStatement(userId, accountNumber);
        return new ResponseEntity<>(transactionList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/bankstatementbasedonuser/{userId}")
    public ResponseEntity<?> bankStatementBasedOnUser(@PathVariable int userId)  {
        List<Transaction> transactionList = transactionServiceImplementation.bankStatementOfUser(userId);
        return new ResponseEntity<>(transactionList, HttpStatus.ACCEPTED);
    }



}
