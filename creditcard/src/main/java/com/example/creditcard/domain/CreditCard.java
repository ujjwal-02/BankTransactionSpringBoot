package com.example.creditcard.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;

@Document(collection = "credit_card_details")
@Data
public class  CreditCard {
    @Id
    private String cardNumber;
    private String creditCardPerks;
    private Double creditScoreBill;
    private Double creditScore;
    private String creditCardName;
    private String creditCardBank;
    private int userId;

    public CreditCard() {
    }

    public CreditCard(String cardNumber, String creditCardPerks, Double creditScoreBill, Double creditScore, String creditCardName, String creditCardBank, int userId) {
        this.cardNumber = cardNumber;
        this.creditCardPerks = creditCardPerks;
        this.creditScoreBill = creditScoreBill;
        this.creditScore = creditScore;
        this.creditCardName = creditCardName;
        this.creditCardBank = creditCardBank;
        this.userId = userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCreditCardPerks() {
        return creditCardPerks;
    }

    public void setCreditCardPerks(String creditCardPerks) {
        this.creditCardPerks = creditCardPerks;
    }

    public Double getCreditScoreBill() {
        return creditScoreBill;
    }

    public void setCreditScoreBill(Double creditScoreBill) {
        this.creditScoreBill = creditScoreBill;
    }

    public Double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Double creditScore) {
        this.creditScore = creditScore;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public String getCreditCardBank() {
        return creditCardBank;
    }

    public void setCreditCardBank(String creditCardBank) {
        this.creditCardBank = creditCardBank;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", creditCardPerks='" + creditCardPerks + '\'' +
                ", creditScoreBill=" + creditScoreBill +
                ", creditScore=" + creditScore +
                ", creditCardName='" + creditCardName + '\'' +
                ", creditCardBank='" + creditCardBank + '\'' +
                ", userId=" + userId +
                '}';
    }
}



