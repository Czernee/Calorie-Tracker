package com.example.internship.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {
    private Long id;
    private String name;
    private int caloriesPerServing;
    private double proteins;
    private double fats;
    private double carbohydrates;
}
