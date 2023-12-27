package com.leonteqsecurity.WholesaleFoodStore.Respository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {
}
