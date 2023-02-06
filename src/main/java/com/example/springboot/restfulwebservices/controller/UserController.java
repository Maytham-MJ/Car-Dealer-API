package com.example.springboot.restfulwebservices.controller;

import com.example.springboot.restfulwebservices.dto.UserDto;
import com.example.springboot.restfulwebservices.entity.User;
import com.example.springboot.restfulwebservices.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // create user
    //http://localhost:8080/api/users
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid  UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>( savedUser, HttpStatus.CREATED);
    }


    //Building Get User by id API
    //http://localhost:8080/api/users/1

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Building Get All Users API
    //http://localhost:8080/api/users

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Building Update User by id API
    //http://localhost:8080/api/users/1
    @PutMapping ("{id}")
    public ResponseEntity<User> updateUser(@PathVariable ("id") Integer id, @Valid @RequestBody User user) {

        user.setId(id);
        User updatedUser = userService.updateUser( user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //Building Delete User by id API
//http://localhost:8080/api/users/1


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User was successfully deleted",  HttpStatus.OK);
    }
}
