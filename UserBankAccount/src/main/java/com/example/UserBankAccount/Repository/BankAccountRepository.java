package com.example.UserBankAccount.Repository;

import com.example.UserBankAccount.Domain.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ListResourceBundle;
import java.util.Optional;

@Repository
public interface BankAccountRepository extends MongoRepository<BankAccount, String> {


    List<BankAccount> findByUserId(int userId);
    Optional<BankAccount> findByAccountNumber(String AccountNumber);
//    List<BankAccount> findByUserId(int userId);
//    List<BankAccount> findByBankName(String bankName);
}
