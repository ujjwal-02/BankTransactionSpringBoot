package com.example.Testing_JWT.repository;

import com.example.Testing_JWT.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    public User findByUserNameAndPassword(String userName , String password);


    Optional<Object> findByUserName(String userName);
}
