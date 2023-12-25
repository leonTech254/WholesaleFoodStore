package com.leonteqsecurity.WholesaleFoodStore.Respository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.FoodProduct;

import java.util.List;

public interface FoodProductDAO {
    List<FoodProduct> findAllProducts();
    FoodProduct findProduct(int productId);
    boolean deleteProduct(int productID);
   boolean updateProduct(FoodProduct productID);
   boolean addProduct(FoodProduct foodProduct);


}
