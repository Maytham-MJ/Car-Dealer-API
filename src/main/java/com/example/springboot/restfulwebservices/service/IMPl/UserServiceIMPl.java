package com.example.springboot.restfulwebservices.service.IMPl;

import com.example.springboot.restfulwebservices.dto.UserDto;
import com.example.springboot.restfulwebservices.entity.User;
import com.example.springboot.restfulwebservices.exception.ResouceNotFoundException;
import com.example.springboot.restfulwebservices.mapper.AutoUserMapper;
import com.example.springboot.restfulwebservices.mapper.UserMapper;
import com.example.springboot.restfulwebservices.repositry.UserRepository;
import com.example.springboot.restfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor

public class UserServiceIMPl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert UserDto to User JPA Entity
        User user = UserMapper.mapToUser(userDto);
        //Save User Entity to DB
      User saveUser = userRepository.save(user);


        //Convert User Entity to UserDto
        return UserMapper.mapToUserDto(saveUser);


    }

    @Override
    public UserDto getUserById(Integer id) {
        return null;
    }


    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResouceNotFoundException("User", "id", id));

        return AutoUserMapper.MAPPER.MapToUserDto(user);
    }



    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updateUser =  userRepository.save(existingUser);
        return updateUser;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}

