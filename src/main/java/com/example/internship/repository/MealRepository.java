package com.example.internship.repository;

import com.example.internship.dto.MealDto;
import com.example.internship.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<MealDto> findByUserIdAndDate(Long userId, LocalDate date);
}
