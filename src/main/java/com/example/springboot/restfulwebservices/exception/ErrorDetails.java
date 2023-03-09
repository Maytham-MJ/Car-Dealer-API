package com.example.springboot.restfulwebservices.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ErrorDetails { // This is the class that show the returned response body formation in case of an exception
    private LocalDateTime timestamp;
    private String message;
    private String path;

    private String errorCode;


    }

