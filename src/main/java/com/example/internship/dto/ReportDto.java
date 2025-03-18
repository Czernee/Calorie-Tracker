package com.example.internship.dto;

import com.example.internship.models.Meal;
import com.example.internship.models.MealDish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {
    private LocalDate date;
    private int totalCalories;
    private List<MealDto> meals;
}
