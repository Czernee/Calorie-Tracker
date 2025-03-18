package com.example.internship.repository;

import com.example.internship.models.MealDish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealDishRepository extends JpaRepository<MealDish, Long> {
}
