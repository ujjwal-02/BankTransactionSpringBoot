package com.example.user.Repository;


import com.example.user.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    public User findByUserNameAndPassword(String userName , String password);

}
