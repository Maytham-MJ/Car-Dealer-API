package com.example.springboot.restfulwebservices.repositry;

import com.example.springboot.restfulwebservices.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

}

