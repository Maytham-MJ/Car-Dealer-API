package com.example.springboot.restfulwebservices.controller;


import com.example.springboot.restfulwebservices.entity.Car;
import com.example.springboot.restfulwebservices.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This is to make this class as a rest controller
@AllArgsConstructor // This is to create a constructor with all the fields

@RequestMapping("api/cars") // http://localhost:8080/api/cars
public class CarController {

    private CarService carService;
    // create cars and save them to database
    @PostMapping  // http://localhost:8080/api/cars
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car savedCar = carService.createCar(car);
        return new ResponseEntity<>(savedCar , HttpStatus.CREATED);

    }

    //Get cars by id from database
    @GetMapping("/{id}") // http://localhost:8080/api/cars/1
    public ResponseEntity<Car> getCarById(@PathVariable("id") Integer id) {
        Car car = carService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    //Get all cars from database
    @GetMapping // http://localhost:8080/api/cars
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    //Update cars by id from database
    @PutMapping("/{id}") // http://localhost:8080/api/cars/1
    public ResponseEntity<Car> updateCar(@PathVariable("id") Integer id, @RequestBody Car car) {
        car.setId(id);
        Car updatedCar = carService.updateCar(car);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    //Delete cars by id from database
    @DeleteMapping("/{id}") // http://localhost:8080/api/cars/1
    public ResponseEntity<String> deleteCar(@PathVariable("id") Integer id) {
        carService.deleteCar(id);
        return new ResponseEntity<>("Car with id " + id + " was deleted", HttpStatus.OK);
    }
}





