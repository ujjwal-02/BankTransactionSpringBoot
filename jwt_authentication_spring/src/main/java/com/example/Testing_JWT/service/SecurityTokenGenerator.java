package com.example.Testing_JWT.service;

import com.example.Testing_JWT.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public Map<String,String>  generateToken(User user);
}
