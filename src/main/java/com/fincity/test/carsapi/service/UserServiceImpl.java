package com.fincity.test.carsapi.service;

/*
 * Created by gusingha on 13-Apr-2020.
 */

import com.fincity.test.carsapi.dao.UserRepository;
import com.fincity.test.carsapi.exception.UserInvalidException;
import com.fincity.test.carsapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User findUser(User user) throws UserInvalidException {

        Optional<User> u =  userRepository.findOne(Example.of(user));
        if(!u.isPresent())
            throw new UserInvalidException("Username and Password doesn't match. Try Login with proper details or register.");
        return u.get();
    }

}
