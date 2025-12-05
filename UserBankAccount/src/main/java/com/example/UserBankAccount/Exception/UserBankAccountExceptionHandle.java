package com.example.UserBankAccount.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserBankAccountExceptionHandle {


    @ExceptionHandler(BankAccountAlreadyExistException.class)
    public ResponseEntity<?> handleBankAccountAlreadyExistException(BankAccountAlreadyExistException bankAccountAlreadyExistException){
        return new ResponseEntity<>("BankAccount Already present Change the required entity", HttpStatus.FOUND);
    }

    @ExceptionHandler(BankAccountNotFoundException.class)
    public ResponseEntity<?> handleBankAccountNotFoundException(BankAccountNotFoundException bankAccountNotFoundException){
        return new ResponseEntity<>("No Such Bank Exist", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountNumberNotExist.class)
    public ResponseEntity<?> handleAccountNumberNotFound(AccountNumberNotExist accountNumberNotExist){
        return new ResponseEntity<>("Enter Correct Account Number", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<?> handleInsufficientBalance(InsufficientBalanceException insufficientBalanceException){
        return new ResponseEntity<>("Insufficient Balance", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> handleReceiverBankAccountNotFound(ReciverBankAccountNotFound reciverBankAccountNotFound){
        return new ResponseEntity<>("receiver Bank Not Found Please Check Account Number", HttpStatus.NOT_FOUND);
    }
}
