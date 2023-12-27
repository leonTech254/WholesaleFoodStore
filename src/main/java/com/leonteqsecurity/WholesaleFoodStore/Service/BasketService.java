package com.leonteqsecurity.WholesaleFoodStore.Service;

import com.leonteqsecurity.WholesaleFoodStore.Models.Basket;
import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    @Autowired
    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }

    public Optional<Basket> getBasketById(int id) {
        return basketRepository.findById(id);
    }

    public Basket saveBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    public void deleteBasket(int id) {
        basketRepository.deleteById(id);
    }

}
