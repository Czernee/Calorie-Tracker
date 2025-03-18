package com.example.internship.service.impl;

import com.example.internship.dto.MealDto;
import com.example.internship.dto.ReportDto;
import com.example.internship.models.Meal;
import com.example.internship.repository.MealRepository;
import com.example.internship.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private MealRepository mealRepository;

    @Autowired
    public ReportServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public ReportDto getDailyReport(Long userId, LocalDate date) {
        List<MealDto> meals = mealRepository.findByUserIdAndDate(userId, date);
        int totalCalories = meals.stream()
                .flatMap(meal -> meal.getMealDishes().stream())
                .mapToInt(md -> md.getDish().getCaloriesPerServing() * md.getQuantity())
                .sum();
        return new ReportDto(date, totalCalories, meals);
    }
}
