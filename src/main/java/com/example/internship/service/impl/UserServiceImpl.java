package com.example.internship.service.impl;

import com.example.internship.models.User;
import com.example.internship.repository.UserRepository;
import com.example.internship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        calculateDailyCalorieGoal(user);
        return userRepository.save(user);
    }

    private void calculateDailyCalorieGoal(User user) {
        double bmr = 88.36 + (13.4 * user.getWeight()) + (4.8 * user.getHeight()) - (5.7 * user.getAge());
        switch (user.getGoal()) {
            case WEIGHT_LOSS: bmr *= 0.9; break;
            case MUSCLE_GAIN: bmr *= 1.1; break;
        }
        user.setDailyCalorieGoal((int) bmr);
    }
}
