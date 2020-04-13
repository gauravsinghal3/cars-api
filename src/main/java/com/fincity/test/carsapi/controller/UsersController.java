package com.fincity.test.carsapi.controller;

/*
 * Created by gusingha on 13-Apr-2020.
 */

import com.fincity.test.carsapi.exception.UserInvalidException;
import com.fincity.test.carsapi.model.User;
import com.fincity.test.carsapi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody User user) {
        return new ResponseEntity(userService.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody User user) throws UserInvalidException {
        User u = userService.findUser(user);
        return "Success";
    }


}
