package com.example.springboot.restfulwebservices.mapper;

import com.example.springboot.restfulwebservices.dto.UserDto;
import com.example.springboot.restfulwebservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper  // This is to tell MapStruct that this is a mapper interface
public interface AutoUserMapper {

    AutoUserMapper MAPPER = org.mapstruct.factory.Mappers.getMapper(AutoUserMapper.class);

    UserDto MapToUserDto(User user);
    User MapToUser(UserDto userDto);
}
