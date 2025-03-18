package com.example.internship.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
    private List<MealDish> mealDishes = new ArrayList<>();
}
