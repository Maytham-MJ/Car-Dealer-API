package com.example.springboot.restfulwebservices.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity //Specifies that the class is an entity. This annotation is applied to the entity class.
@Table(name = "users") //Specifies the primary table for the annotated entity.
public class User {
    @Id //Specifies the primary key of an entity.
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Provides for the specification of generation strategies for the values of primary keys.
    private int id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;



}



