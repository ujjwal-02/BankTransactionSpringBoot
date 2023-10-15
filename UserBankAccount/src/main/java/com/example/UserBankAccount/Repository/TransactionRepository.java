package com.example.UserBankAccount.Repository;

import com.example.UserBankAccount.Domain.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, Integer> {

    //List<Transaction> findByTransactionIdIn(List<Integer> transactionIds);

    public List<Transaction> findByAccountNumberUser1(String accountNumberUser1);

    public List<Transaction> findByUserId(int userId);
}
