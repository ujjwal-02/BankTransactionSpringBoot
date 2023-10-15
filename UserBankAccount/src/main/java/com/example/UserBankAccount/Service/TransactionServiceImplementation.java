package com.example.UserBankAccount.Service;

import com.example.UserBankAccount.Domain.BankAccount;
import com.example.UserBankAccount.Domain.Transaction;
import com.example.UserBankAccount.Exception.BankAccountNotFoundException;
import com.example.UserBankAccount.Exception.InsufficientBalanceException;
import com.example.UserBankAccount.Exception.ReciverBankAccountNotFound;
import com.example.UserBankAccount.Repository.BankAccountRepository;
import com.example.UserBankAccount.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImplementation implements TransactionService{

    static int count = 100;

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Override
    public String transferAmount(int userId, Transaction transaction) throws  BankAccountNotFoundException, InsufficientBalanceException, ReciverBankAccountNotFound {

        String s= "";
//        transaction.setUserId((int) sequenceGeneratorService.generateSequence(transaction.SEQUENCE_NAME));

        if(!bankAccountRepository.findByAccountNumber(transaction.getAccountNumberUser1()).isPresent()){
            throw new BankAccountNotFoundException();
        }
        BankAccount bankAccount = bankAccountRepository.findByAccountNumber(transaction.getAccountNumberUser1()).get();
        if(bankAccount.getBankBalance() < 500.0){
            throw new InsufficientBalanceException();
        }else{
            if(!bankAccountRepository.findByAccountNumber(transaction.getAccountNumberUser2()).isPresent()){
                throw new ReciverBankAccountNotFound();
            }else{
                if(transaction.getTransactionAmount() > bankAccount.getBankBalance()){
                    throw new InsufficientBalanceException();
                }else{
                    BankAccount bankAccount1 = bankAccountRepository.findByAccountNumber(transaction.getAccountNumberUser2()).get();
                    double total = bankAccount.getBankBalance() - transaction.getTransactionAmount();
                    bankAccount.setBankBalance(total);
                    double receivertotal = bankAccount1.getBankBalance() + transaction.getTransactionAmount();
                    bankAccount1.setBankBalance(receivertotal);
                    bankAccountRepository.save(bankAccount1);
                    bankAccountRepository.save(bankAccount);
                    transaction.setUserId(bankAccount.getUserId());
                    transaction.setTransactionId((int) sequenceGeneratorService.generateSequence(transaction.SEQUENCE_NAME));

                    LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());

                    // Set createdAt and updatedAt fields
                    transaction.setCreatedAt(now);
                    transaction.setUpdatedAt(now);

                    // You can also convert LocalDateTime to Date if needed
                    Date createdAtDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
                    Date updatedAtDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
                    transaction.setCreatedAt1(createdAtDate);
                    transaction.setUpdatedAt1(updatedAtDate);

                    transactionRepository.save(transaction);
                    Transaction receiverTransaction = new Transaction();
                    receiverTransaction.setTransactionId(count);
                    count++;
                    receiverTransaction.setTransactionAmount(transaction.getTransactionAmount());
                    receiverTransaction.setTransactionType("credited");
                    receiverTransaction.setTransactionId((int) sequenceGeneratorService.generateSequence(receiverTransaction.SEQUENCE_NAME));

                    receiverTransaction.setCreatedAt(now);
                    receiverTransaction.setUpdatedAt(now);
                    receiverTransaction.setCreatedAt1(createdAtDate);
                    receiverTransaction.setUpdatedAt1(updatedAtDate);

                    receiverTransaction.setAccountNumberUser1(transaction.getAccountNumberUser2());
                    receiverTransaction.setAccountNumberUser2(transaction.getAccountNumberUser1());
                    receiverTransaction.setDescription(transaction.getDescription());
                    receiverTransaction.setUserId(bankAccountRepository.findByAccountNumber(transaction.getAccountNumberUser2()).get().getUserId());
                    transactionRepository.save(receiverTransaction);

                    s += transaction.getTransactionAmount() + " amount transfered successfully.";
                }
            }
        }
        return s;
    }

    @Override
    public List<Transaction> bankStatement(int userId, String accountNumber) throws BankAccountNotFoundException {

        if(!bankAccountRepository.findByAccountNumber(accountNumber).isPresent()){
            throw new BankAccountNotFoundException();
        }
            List<Transaction> list = transactionRepository.findByAccountNumberUser1(accountNumber);
            return list;


    }

    @Override
    public List<Transaction> bankStatementOfUser(int userId) {

            List<Transaction> list = transactionRepository.findByUserId(userId);
            return list;

    }

    @Override
    public List<Transaction> transactionHistoryForBankAccount(int userId, String accountNumber) {

            List<Transaction> list = transactionRepository.findByAccountNumberUser1(accountNumber);
            return list;

    }

    @Override
    public List<Transaction> getTransactionBYDate(int userId, LocalDate ld) {
        List<Transaction> list = bankStatementOfUser(userId);
        List<LocalDate> dates = list.stream()
                .map(transaction -> transaction.getCreatedAt().toLocalDate())
                .collect(Collectors.toList());
        return null;
    }


}
