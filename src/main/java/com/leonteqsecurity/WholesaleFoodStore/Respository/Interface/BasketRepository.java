package com.leonteqsecurity.WholesaleFoodStore.Respository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {
}
