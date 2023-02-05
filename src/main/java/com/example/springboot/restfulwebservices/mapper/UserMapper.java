package com.example.springboot.restfulwebservices.mapper;

import com.example.springboot.restfulwebservices.dto.UserDto;
import com.example.springboot.restfulwebservices.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
        user.getId(),
        user.getFirstName(),
        user.getLastName(),
        user.getEmail()
        );
        return userDto;


    }

    //Convert UserDto to User JPA Entity

    public static User mapToUser(UserDto userDto) {
        User user = new User(
        userDto.getId(),
        userDto.getFirstName(),
        userDto.getLastName(),
        userDto.getEmail()
        );
        return user;


    }
}
