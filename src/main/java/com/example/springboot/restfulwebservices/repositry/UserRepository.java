package com.example.springboot.restfulwebservices.repositry;

import com.example.springboot.restfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}

