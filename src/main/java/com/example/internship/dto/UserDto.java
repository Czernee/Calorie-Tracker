package com.example.internship.dto;

import com.example.internship.models.Goal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private int age;
    private double weight;
    private double height;
    private Goal goal;
    private int dailyCalorieGoal;
}
