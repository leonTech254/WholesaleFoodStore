package com.leonteqsecurity.WholesaleFoodStore.Respository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.FoodProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodProductRespository extends JpaRepository<FoodProduct, Integer> {

    @Query(value = "SELECT * FROM foodproduct", nativeQuery = true)
    List<FoodProduct> findAllProducts();

    // Raw SQL for other methods:
    @Query(value = "SELECT * FROM foodproduct WHERE id = ?", nativeQuery = true)
    FoodProduct findProduct(int productId);

    @Query(value = "DELETE FROM foodproduct WHERE id = ?", nativeQuery = true)
    boolean deleteProduct(int productId);

    @Query(value = "UPDATE foodproduct SET description = ?, price = ? WHERE id = ?", nativeQuery = true)
    boolean updateProduct(String newDescription, int newPrice);

    @Query(value = "INSERT INTO foodproduct (SKU, description, category, price) VALUES (?, ?, ?, ?)", nativeQuery = true)
    boolean addProduct(String SKU, String description, String category, int price);
}
