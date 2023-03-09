package com.example.springboot.restfulwebservices.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//We annotate this class with @ResponseStatus to tell Spring that we want to return a 404 Not Found status code when this exception is thrown.
@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class ResouceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    // Constructor
    public ResouceNotFoundException(String resourceName, String fieldName, Integer fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = Long.valueOf(fieldValue);
    }

    public ResouceNotFoundException(String resourceName) {
    }

    public String getResourceName() {
        return resourceName;
    }
}
