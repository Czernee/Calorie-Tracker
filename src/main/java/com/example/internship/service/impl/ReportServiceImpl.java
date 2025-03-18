package com.example.internship.service.impl;

import com.example.internship.dto.DishDto;
import com.example.internship.dto.MealDishDto;
import com.example.internship.dto.MealDto;
import com.example.internship.dto.ReportDto;
import com.example.internship.models.Dish;
import com.example.internship.models.Meal;
import com.example.internship.models.MealDish;
import com.example.internship.repository.MealRepository;
import com.example.internship.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final MealRepository mealRepository;

    @Autowired
    public ReportServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public ReportDto getDailyReport(Long userId, LocalDate date) {
        List<Meal> meals = mealRepository.findByUserIdAndDate(userId, date);

        List<MealDto> mealDtos = meals.stream()
                .map(this::mapToMealDto)
                .toList();

        int totalCalories = mealDtos.stream()
                .flatMap(meal -> meal.getMealDishes().stream())
                .mapToInt(md -> md.getDish().getCaloriesPerServing() * md.getQuantity())
                .sum();

        return new ReportDto(date, totalCalories, mealDtos);
    }

    private MealDto mapToMealDto(Meal meal) {
        List<MealDishDto> mealDishDtos = meal.getMealDishes().stream()
                .map(this::mapToMealDishDto)
                .toList();

        return new MealDto(
                meal.getId(),
                meal.getUser().getId(),
                meal.getDateTime(),
                mealDishDtos
        );
    }

    private MealDishDto mapToMealDishDto(MealDish mealDish) {
        return new MealDishDto(
                mealDish.getId(),
                mapToDishDto(mealDish.getDish()),
                mealDish.getQuantity()
        );
    }

    private DishDto mapToDishDto(Dish dish) {
        return new DishDto(
                dish.getId(),
                dish.getName(),
                dish.getCaloriesPerServing(),
                dish.getProteins(),
                dish.getFats(),
                dish.getCarbohydrates()
        );
    }
}
