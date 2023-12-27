package com.leonteqsecurity.WholesaleFoodStore.Respository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.FoodItem;
import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    // Create
    public FoodItem saveFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    // Read
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public Optional<FoodItem> getFoodItemById(int id) {
        return foodItemRepository.findById(id);
    }

    // Update
    public FoodItem updateFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    // Delete
    public void deleteFoodItem(int id) {
        foodItemRepository.deleteById(id);
    }
}
