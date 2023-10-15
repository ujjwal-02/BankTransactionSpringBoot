package com.example.creditcard.repository;

import com.example.creditcard.domain.CreditCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends MongoRepository<CreditCard, String> {

    List<CreditCard> findByUserId(int userId);
}
