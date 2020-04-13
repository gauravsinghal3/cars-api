package com.fincity.test.carsapi.exception;

/*
 * Created by gusingha on 13-Apr-2020.
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserInvalidException extends RuntimeException{
    public UserInvalidException(String message) {
        super(message);
    }
}
