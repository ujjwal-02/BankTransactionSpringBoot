package com.example.Testing_JWT.service;

import com.example.Testing_JWT.domain.User;
import com.example.Testing_JWT.exception.UserAlreadyExistsException;

public interface UserService {
    public User  addUser(User user) throws UserAlreadyExistsException;

    public User checkUserNameAndPassword(User user);
}
