package com.example.springboot.restfulwebservices.dto;

import com.example.springboot.restfulwebservices.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto extends User {

       private int id;
       @NotEmpty(message = "User firstname should not be empty!")// This is to  make sure that the firstName is not empty
       private String firstName;
       @NotEmpty (message = " User lastname should not be empty! ")// This is to  make sure that the lastName is not empty
       private String lastName;
       @NotEmpty(message = "User email should not be empty") // This is to  make sure that the email is not empty
       @Email (message = "User email should be valid") // This is to  make sure that the email is valid
       private String email;







}
