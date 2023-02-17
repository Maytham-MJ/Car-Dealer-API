package com.example.springboot.restfulwebservices.service;

import com.example.springboot.restfulwebservices.dto.UserDto;
import com.example.springboot.restfulwebservices.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Integer id);


    UserDto getUserById(int id);

    List<User> getAllUsers();

    User updateUser( User user);

    void deleteUser(Integer id);


}
