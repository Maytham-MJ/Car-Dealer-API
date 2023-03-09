package com.example.springboot.restfulwebservices.service.IMPl;

import com.example.springboot.restfulwebservices.dto.UserDto;
import com.example.springboot.restfulwebservices.entity.User;

import com.example.springboot.restfulwebservices.exception.ResourceNotFoundException;
import com.example.springboot.restfulwebservices.mapper.AutoUserMapper;
import com.example.springboot.restfulwebservices.mapper.UserMapper;
import com.example.springboot.restfulwebservices.repositry.UserRepository;
import com.example.springboot.restfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor

public class UserServiceIMPl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private ModelMapper modelMapper; //injection of ModelMapper bean





        public  UserServiceIMPl(UserRepository userRepository, UserMapper userMapper) {
            this.userRepository = userRepository;
            this.userMapper = userMapper;
        }

    public UserServiceIMPl() {

    }


    // Implementation of UserService methods goes here



    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert UserDto to User JPA Entity
//        User user = UserMapper.mapToUser(userDto);
//        User user = modelMapper.map(userDto, User.class);
        User user = AutoUserMapper.MAPPER.MapToUser(userDto);
        //Save User Entity to DB
        User saveUser = userRepository.save(user);
        //Convert User Entity to UserDto
//        UserDto saveUserDto = modelMapper.map(saveUser, UserDto.class);
        UserDto saveUserDto = AutoUserMapper.MAPPER.MapToUserDto(saveUser);
        return saveUserDto;


    }

    @Override
    public UserDto getUserById(int id) { //we are going to add Exception handling custom message.

            User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));



//        Optional<User> optionalUser = userRepository.findById(id);

//        return UserMapper.mapToUserDto(user);
//        return modelMapper.map(user, UserDto.class);
//        return AutoUserMapper.MAPPER.MapToUserDto(user);
        return AutoUserMapper.MAPPER.MapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
//        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return users.stream().map(AutoUserMapper.MAPPER::MapToUserDto).collect(Collectors.toList());
    }


    @Override
    public void deleteUser(Integer id) {
        User optionalUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        userRepository.deleteById(id);
    }


    @Override
    public UserDto updateUser(UserDto user) {
     User exisitingUser = userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", user.getId()));
        exisitingUser.setFirstName(user.getFirstName());
        exisitingUser.setLastName(user.getLastName());
        exisitingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(exisitingUser);
//        return UserMapper.mapToUserDto(updatedUser);
//        return modelMapper.map(updatedUser, UserDto.class);
        return AutoUserMapper.MAPPER.MapToUserDto(updatedUser);

    }




}

