// UserService.java
package com.example.user.Service;

import com.example.user.Domain.User;
import com.example.user.Exception.UserAlreadyExistException;
import com.example.user.Exception.UserNotFoundException;

public interface UserService {

    User addUser(User user) throws UserAlreadyExistException;

    String updateUser(User user, int userId) throws UserNotFoundException;

    String deleteUser(int userId) throws UserNotFoundException;

    User getUser(int userId) throws UserNotFoundException;

    public User checkUserNameAndPassword(String userName, String password);
}
