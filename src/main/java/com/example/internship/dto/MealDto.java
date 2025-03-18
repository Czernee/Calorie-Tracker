package com.example.internship.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealDto {
    private Long id;
    private Long userId;
    private LocalDateTime dateTime;
    private List<MealDishDto> mealDishes;
}
