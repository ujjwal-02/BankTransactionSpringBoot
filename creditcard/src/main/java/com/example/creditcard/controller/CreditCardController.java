package com.example.creditcard.controllers;

import com.example.creditcard.domain.CreditCard;
import com.example.creditcard.services.CreditCardServiceImpl;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creditcards")
@CrossOrigin
public class CreditCardController {
    @Autowired
    CreditCardServiceImpl creditCardService;

    @PostMapping("/addcreditcard/{userId}")
    public ResponseEntity<?> addCreditCard(@PathVariable int userId,@RequestBody CreditCard creditCard){
        String s= creditCardService.addCreditCard(userId, creditCard);
        return new ResponseEntity<>(s, HttpStatus.ACCEPTED);

    }

    @GetMapping("/getcreditcard/{creditCardNumber}")
    public ResponseEntity<?> addCreditCard(@PathVariable String creditCardNumber){
        CreditCard creditCard= creditCardService.getCreditCardDetails(creditCardNumber);
        return new ResponseEntity<>(creditCard, HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/removecreditcard/{creditCardNumber}")
    public ResponseEntity<?> removeCreditCard(@PathVariable String creditCardNumber){
        String s= creditCardService.removeCreditCard(creditCardNumber);
        return new ResponseEntity<>(s, HttpStatus.ACCEPTED);

    }

    @GetMapping("/getallcreditcard/{userId}")
    public ResponseEntity<?> addCreditCard(@PathVariable int userId){
        List<CreditCard> list= creditCardService.getAllBasedOnUserId(userId);
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);

    }

}
