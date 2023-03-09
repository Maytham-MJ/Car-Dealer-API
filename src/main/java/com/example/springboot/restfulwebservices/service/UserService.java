package com.example.springboot.restfulwebservices.service;

import com.example.springboot.restfulwebservices.dto.UserDto;
import com.example.springboot.restfulwebservices.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(int id);

    List<UserDto> getAllUsers();


    void deleteUser(Integer id);


    UserDto updateUser(UserDto user);
}
