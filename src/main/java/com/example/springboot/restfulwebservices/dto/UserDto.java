package com.example.springboot.restfulwebservices.dto;

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
public class UserDto {

       private int id;
       @NotEmpty // This is to  make sure that the firstName is not empty
       private String firstName;
       @NotEmpty // This is to  make sure that the lastName is not empty
       private String lastName;
       @NotEmpty // This is to  make sure that the email is not empty
       @Email
       private String email;



}
