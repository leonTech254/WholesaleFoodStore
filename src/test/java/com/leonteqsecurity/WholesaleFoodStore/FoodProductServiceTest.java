package com.leonteqsecurity.WholesaleFoodStore;

import com.leonteqsecurity.WholesaleFoodStore.Models.FoodProduct;
import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.FoodProductRepository;
import com.leonteqsecurity.WholesaleFoodStore.Service.FoodProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FoodProductServiceTest {

    @Mock
    private FoodProductRepository foodProductRepository;

    @InjectMocks
    private FoodProductService foodProductService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllProducts() {
        // Arrange
        List<FoodProduct> mockProducts = new ArrayList<>();
        when(foodProductRepository.findAllProducts()).thenReturn(mockProducts);

        // Act
        List<FoodProduct> result = foodProductService.findAllProducts();

        // Assert
        assertEquals(mockProducts, result);
    }

    @Test
    void testFindProduct() {
        // Arrange
        int productId = 1;
        FoodProduct mockProduct = new FoodProduct();
        when(foodProductRepository.findProduct(productId)).thenReturn(mockProduct);

        // Act
        FoodProduct result = foodProductService.findProduct(productId);

        // Assert
        assertEquals(mockProduct, result);
    }

    // Similar tests for other methods...

    @Test
    void testFilterProductsByName() {
        // Arrange
        String category = "TestCategory";
        List<FoodProduct> mockProducts = new ArrayList<>();
        when(foodProductRepository.findAllProducts()).thenReturn(mockProducts);

        // Act
        List<FoodProduct> result = foodProductService.filterProductsByName(category);

        // Assert
        assertEquals(mockProducts, result);
    }

    @Test
    void testFindByDescriptionContaining() {
        // Arrange
        String keyword = "TestKeyword";
        List<FoodProduct> mockProducts = new ArrayList<>();
        when(foodProductRepository.findAllProducts()).thenReturn(mockProducts);

        // Act
        List<FoodProduct> result = foodProductService.findByDescriptionContaining(keyword);

        // Assert
        assertEquals(mockProducts, result);
    }

}
