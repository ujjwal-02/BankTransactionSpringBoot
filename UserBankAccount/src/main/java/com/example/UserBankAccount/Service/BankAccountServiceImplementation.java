package com.example.UserBankAccount.Service;

import com.example.UserBankAccount.Domain.BankAccount;
import com.example.UserBankAccount.Exception.AccountNumberNotExist;
import com.example.UserBankAccount.Exception.BankAccountAlreadyExistException;
import com.example.UserBankAccount.Exception.BankAccountNotFoundException;
import com.example.UserBankAccount.Repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountServiceImplementation implements BankAccountService{

    @Autowired
    BankAccountRepository bankAccountRepository;



    @Override
    public String addBank(BankAccount bankAccount, int userId) throws BankAccountAlreadyExistException {

        //String s = "Created bank account of " + bankAccount.getBankName();

        if(!bankAccountRepository.findByAccountNumber(bankAccount.getAccountNumber()).isPresent()){
            bankAccount.setUserId(userId);
//            bankAccount.setAccountNumber(bankAccount.getAccountNumber());
            bankAccountRepository.save(bankAccount);
//            List<String> accountNumberList = userRepository.findById(userId).get().getAccountNumber();
//            if(accountNumberList.isEmpty()){
//                accountNumberList.add(bankAccount.getAccountNumber());
//            }
            return "bank account created";
        }else{
            throw new BankAccountAlreadyExistException();
        }

//        if(bankAccountRepository.findByAccountNumber(bankAccount.getAccountNumber()).isPresent()){
//            BankAccount bankAccount1 = bankAccountRepository.findByAccountNumber(bankAccount.getAccountNumber()).get();
//            if(bankAccount1.getAccountNumber().equals(bankAccount.getAccountNumber()) && bankAccount1.getBankName().equals(bankAccount.getBankName()) && bankAccount1.getBranchName().equals(bankAccount.getBranchName())){
//                throw new BankAccountAlreadyExistException();
//            }else{
//                bankAccount.setUserId(userId);
//                List<String> accountNumberList = userRepository.findById(userId).get().getAccountNumber();
//                accountNumberList.add(bankAccount.getAccountNumber());
//                userRepository.findById(userId).get().setAccountNumber(accountNumberList);
//                bankAccountRepository.save(bankAccount);
//                return "Bank account created successfully";
//            }
//        }
    }

    @Override
    public String removeBankAccount(String AccountNumber) throws BankAccountNotFoundException {
        if(!bankAccountRepository.findByAccountNumber(AccountNumber).isPresent()){
            throw new BankAccountNotFoundException();
        }else{
            BankAccount bankAccount = bankAccountRepository.findByAccountNumber(AccountNumber).get();
            int userId=  bankAccount.getUserId();
//            List<String> accountNumberList = userRepository.findById(userId).get().getAccountNumber();
//            for(String an:accountNumberList){
//                if(an.equals(AccountNumber)){
//                    accountNumberList.remove(an);
//                    break;
//                }
//            }
            bankAccountRepository.delete(bankAccount);
            return "Account Deleted Successfully";
        }
    }

    @Override
    public BankAccount getBankAccountBasedOnBankAccountNumber(String AccountNumber) throws BankAccountNotFoundException, AccountNumberNotExist {
        if(!bankAccountRepository.findByAccountNumber(AccountNumber).isPresent()){
            throw new BankAccountNotFoundException();
        }else{
            BankAccount bankAccount = bankAccountRepository.findByAccountNumber(AccountNumber).get();
            if(bankAccount == null){
                throw new AccountNumberNotExist();
            }else {
                return bankAccount;
            }
        }
    }

    @Override
    public List<BankAccount> getAllAccountOfUserBasedOnUserId(int userId) throws  BankAccountNotFoundException {

            List<BankAccount> bankAccountList = bankAccountRepository.findByUserId(userId);
            return  bankAccountList;
//            List<BankAccount> bankAccountListBasedOnUser = new ArrayList<>();
//            for(BankAccount ba: bankAccountList){
//                if(ba.getUserId() == userId){
//                    bankAccountListBasedOnUser.add(ba);
//                }
//            }
//            if(bankAccountListBasedOnUser.isEmpty()){
//                throw new BankAccountNotFoundException();
//            }else{
//                return bankAccountListBasedOnUser;
//            }

    }

    @Override
    public List<BankAccount> getBankAccountBasedOnBankName(String bankName, int userId) throws  BankAccountNotFoundException {

            List<BankAccount> bankAccountList = bankAccountRepository.findAll();
            List<BankAccount> bankAccountListBasedOnBankName = new ArrayList<>();
            for(BankAccount ba: bankAccountList){
                if(ba.getBankName().equals(bankName)){
                    bankAccountListBasedOnBankName.add(ba);
                }
            }
            if(bankAccountListBasedOnBankName.isEmpty()){
                throw new BankAccountNotFoundException();
            }else{
                return bankAccountListBasedOnBankName;
            }


    }

    @Override
    public List<BankAccount> getAllBankAccount() throws BankAccountNotFoundException {
        List<BankAccount> bankAccountList = bankAccountRepository.findAll();
        if(bankAccountList.isEmpty()){
            throw new BankAccountNotFoundException();
        }else{
            return bankAccountList;
        }

    }

    @Override
    public BankAccount checkBalance(int userId, String accountNumber) throws  BankAccountNotFoundException {

            if(!bankAccountRepository.findByAccountNumber(accountNumber).isPresent()){
                throw new BankAccountNotFoundException();
            }else{
                BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber).get();
//                String bankName = bankAccountRepository.findByAccountNumber(accountNumber).get().getBankName();
//                String s = "Balance account for " + bankName + " is "+ balance;
                return bankAccount;
            }

    }

    @Override
    public String updateBankAccount(BankAccount bankAccount) throws BankAccountNotFoundException{
        if(!bankAccountRepository.findByAccountNumber(bankAccount.getAccountNumber()).isPresent()){
            throw new BankAccountNotFoundException();
        }else{

                BankAccount bankAccount1 = bankAccountRepository.findByAccountNumber(bankAccount.getAccountNumber()).get();
                bankAccount1.setBankBalance(bankAccount.getBankBalance());
                bankAccount1.setAccountType(bankAccount.getAccountType());
                bankAccount1.setBankName(bankAccount.getBankName());
                bankAccount1.setAccountNumber(bankAccount.getAccountNumber());
                bankAccount1.setIfscCode(bankAccount.getIfscCode());
                bankAccountRepository.save(bankAccount1);
                return "Bank account updated successfully";

        }
    }


}
