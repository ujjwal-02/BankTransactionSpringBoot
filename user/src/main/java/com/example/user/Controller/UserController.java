// UserController.java
package com.example.user.Controller;

import com.example.user.Domain.User;
import com.example.user.Exception.UserAlreadyExistException;
import com.example.user.Exception.UserNotFoundException;
import com.example.user.Service.UserService;
import com.example.user.Service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImplementation userService;

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody User user) throws UserAlreadyExistException {
        User response = userService.addUser(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/updateuser/{userId}")
    public ResponseEntity<String> updateUser(@RequestBody User user,@PathVariable int userId) throws UserNotFoundException {
        String response = userService.updateUser(user, userId);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteuser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) throws UserNotFoundException {
        String response = userService.deleteUser(userId);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getuserdetails/{userId}")
    public ResponseEntity<User> getUserDetails(@PathVariable int userId) throws UserNotFoundException {
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getuserid/{userName}/{password}")
    public ResponseEntity<User> getUserId(@PathVariable String userName, @PathVariable String password){
        User user = userService.checkUserNameAndPassword(userName,password);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
