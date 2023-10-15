package com.example.Testing_JWT.service;

import com.example.Testing_JWT.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceTokenGeneratorImpl implements SecurityTokenGenerator {
    Map<String,String> jwtMap=new HashMap<>();

    @Override
    public Map<String, String> generateToken(User user) {

        String jwtToken;
        jwtToken= Jwts.builder().setSubject(user.getUserName()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,"userkey").compact();
        jwtMap.put("token",jwtToken);
        jwtMap.put("message","token generated");
        return jwtMap;



    }
}
