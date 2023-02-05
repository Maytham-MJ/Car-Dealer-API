package com.example.springboot.restfulwebservices.service;

import com.example.springboot.restfulwebservices.entity.Car;

import java.util.List;

public interface CarService {
    Car createCar(Car car); // create a car

    Car getCarById(Integer id); // get a car by id

    List<Car> getAllCars(); // get all cars

    Car updateCar( Car car); // update a car

    void deleteCar(Integer id); // delete a car

}

