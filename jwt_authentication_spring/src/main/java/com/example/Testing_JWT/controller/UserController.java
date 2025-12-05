package com.example.Testing_JWT.controller;

import com.example.Testing_JWT.domain.User;
import com.example.Testing_JWT.exception.UserAlreadyExistsException;
import com.example.Testing_JWT.service.SecurityTokenGenerator;
import com.example.Testing_JWT.service.ServiceTokenGeneratorImpl;
import com.example.Testing_JWT.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/userauth")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    ServiceTokenGeneratorImpl securityTokenGeneratorImpl;

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userServiceImpl.addUser(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> checkUser(@RequestBody User user) {
        Map<String,String> jwttoken=new HashMap<>();

        User user1=userServiceImpl.checkUserNameAndPassword(user);
        if(user1!=null)
        {
            jwttoken=securityTokenGeneratorImpl.generateToken(user);
            return new ResponseEntity<>(jwttoken,HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>("Check Credentials",HttpStatus.OK);

        }
    }


}
