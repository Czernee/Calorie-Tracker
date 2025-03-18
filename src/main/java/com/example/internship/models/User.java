package com.example.internship.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;

    private int age;
    private double weight;
    private double height;

    @Enumerated(EnumType.STRING)
    private Goal goal;

    private int dailyCalorieGoal;
}
