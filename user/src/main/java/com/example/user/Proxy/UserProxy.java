package com.example.user.Proxy;


import com.example.user.Domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "TestingJwtApplication",url = "localhost:8081")
public interface UserProxy {
    @PostMapping("/userauth/register")
    public ResponseEntity<?> addUser(@RequestBody User user);

}
