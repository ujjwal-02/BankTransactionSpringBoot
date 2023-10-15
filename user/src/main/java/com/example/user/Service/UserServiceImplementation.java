// UserServiceImplementation.java
package com.example.user.Service;

import com.example.user.Domain.User;
import com.example.user.Exception.UserAlreadyExistException;
import com.example.user.Exception.UserNotFoundException;
import com.example.user.Proxy.UserProxy;
import com.example.user.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Objects;


import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@Service
public class UserServiceImplementation implements UserService {



    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    MongoOperations mongoOperations;

//    public int generateSequence(String seqName) {
//        User user = mongoOperations.findAndModify(query(where("_id").is(seqName)),
//                new Update().inc("seq",1), options().returnNew(true).upsert(true),
//                User.class);
//        return !Objects.isNull(user) ? user.getUserId() : 1;
//    }

//    public long generateSequence(String seqName) {
//        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
//                new Update().inc("seq",1), options().returnNew(true).upsert(true),
//                DatabaseSequence.class);
//        return !Objects.isNull(counter) ? counter.getSeq() : 1;
//    }
    @Autowired
    UserProxy userProxy;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Override
    public User addUser(User user) throws UserAlreadyExistException {

        user.setUserId((int) sequenceGeneratorService.generateSequence(user.SEQUENCE_NAME));
        System.out.println(user);
        if (!userRepository.findById(user.getUserId()).isPresent()) {
            userRepository.save(user);
            userProxy.addUser(user);
            return user;
        } else {
            throw new UserAlreadyExistException();
        }
    }

    @Override
    public String updateUser(User user, int userId) throws UserNotFoundException {
        String response = "";
        if (userRepository.findById(userId).isPresent()) {
            userRepository.save(user);
            response = "User details updated";
        } else {
            throw new UserNotFoundException();
        }
        return response;
    }

    @Override
    public String deleteUser(int userId) throws UserNotFoundException {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return "User deleted";
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User getUser(int userId) throws UserNotFoundException {
        if(!userRepository.findById(userId).isPresent()){
            throw new UserNotFoundException();
        }
        return userRepository.findById(userId).get();
    }

    @Override
    public User checkUserNameAndPassword(String userName, String password) {
        User checkUser = userRepository.findByUserNameAndPassword(userName, password);
        if(checkUser!=null){
            return checkUser;
        }
        else {
            return null;
        }
    }
}
