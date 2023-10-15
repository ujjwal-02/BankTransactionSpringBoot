package com.example.creditcard.services;

import com.example.creditcard.domain.CreditCard;

import java.util.List;

public interface CreditCardService {

    public String addCreditCard(int userId, CreditCard creditCard);
    public CreditCard getCreditCardDetails(String creditCardNumber);

    public String removeCreditCard(String creditCardNUmber);


}
