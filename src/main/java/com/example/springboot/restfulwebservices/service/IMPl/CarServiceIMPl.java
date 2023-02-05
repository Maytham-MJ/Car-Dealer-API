package com.example.springboot.restfulwebservices.service.IMPl;

import com.example.springboot.restfulwebservices.entity.Car;
import com.example.springboot.restfulwebservices.repositry.CarRepository;
import com.example.springboot.restfulwebservices.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CarServiceIMPl implements CarService {


    private CarRepository carRepository;

    // create a car
    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);


    }

    // get a car by id
    @Override
    public Car getCarById(Integer id) {
        Optional<Car> car = carRepository.findById(id);
        return car.get();
    }

    // get all cars
    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }


    // update a car
    @Override
    public Car updateCar(Car car) {
        Car existingCar = carRepository.findById(car.getId()).get(); // get the car by id from the database.
        existingCar.setMake(car.getMake());
        existingCar.setModel(car.getModel());
        existingCar.setYear(car.getYear());
        existingCar.setColor(car.getColor());
        existingCar.setMileage(car.getMileage());
        existingCar.setPrice(car.getPrice());
        existingCar.setImg(car.getImg());

        Car updateCar =  carRepository.save(existingCar); // save the updated car to the database.
        return updateCar; // return the updated car.
    }

    @Override // delete a car
    public void deleteCar(Integer id) {
        carRepository.deleteById(id); // delete the car by id from the database.
    }
}
