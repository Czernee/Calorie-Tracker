package com.example.internship.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "meal_dish")
@Getter
@Setter
public class MealDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Meal meal;

    @ManyToOne
    private Dish dish;

    private int quantity;
}