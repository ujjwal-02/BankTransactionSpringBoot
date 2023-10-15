package com.example.Testing_JWT.service;

import com.example.Testing_JWT.domain.User;
import com.example.Testing_JWT.exception.UserAlreadyExistsException;
import com.example.Testing_JWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
        if (!userRepository.findByUserName(user.getUserName()).isPresent()) {
            userRepository.save(user);
        } else {
            throw new UserAlreadyExistsException();
        }
        return user;
    }


    @Override
    public User checkUserNameAndPassword(User user) {
        User checkUser = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
        if(checkUser!=null){
            return user;
        }
        else {
            return null;
        }
    }
}
