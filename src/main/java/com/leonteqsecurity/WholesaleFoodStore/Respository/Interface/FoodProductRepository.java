package com.leonteqsecurity.WholesaleFoodStore.Respository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.FoodProduct;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodProductRepository extends JpaRepository<FoodProduct, Integer> {

    @Query(value = "SELECT * FROM foodproduct", nativeQuery = true)
    List<FoodProduct> findAllProducts();

    @Query(value = "SELECT * FROM foodproduct WHERE id = ?", nativeQuery = true)
    FoodProduct findProduct(int productId);

    @Modifying
    @Query(value = "DELETE FROM foodproduct WHERE id = ?", nativeQuery = true)
    boolean deleteProduct(int productId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE foodproduct SET description = ?, price = ? WHERE id = ?", nativeQuery = true)
    boolean updateProduct(String newDescription, int newPrice, int productId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO foodproduct (SKU, description, category, price) VALUES (?, ?, ?, ?)", nativeQuery = true)
    void addProduct(String SKU, String description, String category, int price);
}
