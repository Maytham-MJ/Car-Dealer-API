package com.example.springboot.restfulwebservices.service.IMPl;

import com.example.springboot.restfulwebservices.mapper.UserMapper;
import com.example.springboot.restfulwebservices.repositry.UserRepository;
import com.example.springboot.restfulwebservices.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {




        @Bean
        public UserMapper userMapper() {
            return new UserMapper();
        }

        @Bean
        public UserService userService(UserRepository userRepository, UserMapper userMapper) {
            return new UserServiceIMPl(userRepository, userMapper);
        }




}
