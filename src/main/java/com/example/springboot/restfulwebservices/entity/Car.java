package com.example.springboot.restfulwebservices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity //Specifies that the class is an entity. This annotation is applied to the entity class.

@AllArgsConstructor //Generates a constructor with 1 parameter for each field in your class.
@NoArgsConstructor //Generates a constructor with no parameters.
@Table (name = "cars") //Specifies the primary table for the annotated entity.

public class Car {

    @Id //Specifies the primary key of an entity.
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Provides for the specification of generation strategies for the values of primary keys.
    private int id;
    @Column(nullable = false)
    private String make;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String year;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String mileage;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false, unique = true)
    private String img;


}
