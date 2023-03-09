package com.example.springboot.restfulwebservices.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistsException extends RuntimeException{
    private String message;


    // Constructor
    public EmailAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
