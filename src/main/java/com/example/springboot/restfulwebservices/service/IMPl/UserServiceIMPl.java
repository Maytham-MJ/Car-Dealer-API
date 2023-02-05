package com.example.springboot.restfulwebservices.service.IMPl;

import com.example.springboot.restfulwebservices.dto.UserDto;
import com.example.springboot.restfulwebservices.entity.User;
import com.example.springboot.restfulwebservices.mapper.UserMapper;
import com.example.springboot.restfulwebservices.repositry.UserRepository;
import com.example.springboot.restfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor

public class UserServiceIMPl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert UserDto to User JPA Entity
        User user = UserMapper.mapToUser(userDto);
        //Save User Entity to DB
      User saveUser = userRepository.save(user);


        //Convert User Entity to UserDto
        UserDto savedUserDto = UserMapper.mapToUserDto(saveUser);
        return savedUserDto;


    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
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

