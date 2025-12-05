package com.example.creditcard.services;

import com.example.creditcard.domain.CreditCard;
import com.example.creditcard.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    @Override
    public String addCreditCard(int userId, CreditCard creditCard) {
        creditCard.setUserId(userId);
        creditCardRepository.save(creditCard);
        return "Credit card added successfully";
    }

    @Override
    public CreditCard getCreditCardDetails(String creditCardNumber) {
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(creditCardNumber);
        return optionalCreditCard.orElse(null);
    }

    @Override
    public String removeCreditCard(String creditCardNumber) {
        creditCardRepository.deleteById(creditCardNumber);
        return "Credit card removed successfully";
    }


    public List<CreditCard> getAllBasedOnUserId(int userId) {
        List<CreditCard> list = creditCardRepository.findByUserId(userId);
        return list;
    }
}
