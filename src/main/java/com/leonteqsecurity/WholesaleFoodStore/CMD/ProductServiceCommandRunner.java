package com.leonteqsecurity.WholesaleFoodStore.CMD;

import com.leonteqsecurity.WholesaleFoodStore.Models.FoodProduct;
import com.leonteqsecurity.WholesaleFoodStore.Service.FoodProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class ProductServiceCommandRunner {
    private final FoodProductService productService;
    public void runMenu()
    {
        // Your interactive command logic goes here
        System.out.println("THE FOOD STORE\nChoose from these options");
        System.out.println("__________________________________________");
        HashMap<Integer, String> userMenu = new HashMap<>();
        userMenu.put(1, "List all products");
        userMenu.put(2, "Search for product by ID");
        userMenu.put(3, "Add a new Product");
        userMenu.put(4, "Update a Product By ID");
        userMenu.put(5, "Delete a product by ID");

        String userChoice;

        Scanner scanner = new Scanner(System.in);
        do {
            for (Map.Entry<Integer, String> entry : userMenu.entrySet()) {
                int key = entry.getKey();
                String value = entry.getValue();
                System.out.printf("[%d]\t%s%n", key, value);
            }

            System.out.print("Enter your choice: ");
            userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    System.out.println("Listing all products:");
                    productService.findAllProducts().forEach(product -> System.out.println(product.toString()));
                    break;

                case "2":
                    System.out.println("Search product by ID");
                    System.out.print("Enter product ID: ");
                    String productId = scanner.nextLine();
                    try {
                        int id = Integer.parseInt(productId);
                        FoodProduct foundProduct = productService.findProduct(id);

                        if (foundProduct != null) {
                            System.out.println("Found product: " + foundProduct.toString());
                        } else {
                            System.out.println("Product not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Choice");
                    }
                    break;

                case "3":
                    System.out.println("Add a new product");
                    System.out.print("Enter SKU: ");
                    String sku = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter price: ");
                    String priceStr = scanner.nextLine();

                    try {
                        int price = Integer.parseInt(priceStr);
                        FoodProduct newProduct = new FoodProduct(sku, description, category, price);
                        boolean isAdded = productService.addProduct(newProduct);

                        if (isAdded) {
                            System.out.println("Product added successfully.");
                        } else {
                            System.out.println("Failed to add the product.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price. Please enter a valid number.");
                    }
                    break;

                case "4":
                    System.out.println("Update a product by ID");
                    System.out.print("Enter product ID: ");
                    String updateProductId = scanner.nextLine();

                    try {
                        int updateId = Integer.parseInt(updateProductId);

                        FoodProduct existingProduct = productService.findProduct(updateId);
                        if (existingProduct != null) {
                            System.out.println("Found product: " + existingProduct.toString());

                            System.out.print("Enter new description (or press Enter to keep existing): ");
                            String newDescription = scanner.nextLine();

                            System.out.print("Enter new price (or press Enter to keep existing): ");
                            String newPriceStr = scanner.nextLine();

                            boolean isUpdated = productService.updateProduct(
                                    new FoodProduct(updateId, newDescription, Integer.parseInt(newPriceStr)));

                            if (isUpdated) {
                                System.out.println("Product updated successfully.");
                            } else {
                                System.out.println("Failed to update the product.");
                            }
                        } else {
                            System.out.println("Product not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid product ID. Please enter a valid integer.");
                    }
                    break;

                case "5":
                    System.out.println("Delete a product by ID");
                    System.out.print("Enter product ID: ");
                    String deleteProductId = scanner.nextLine();

                    try {
                        int deleteId = Integer.parseInt(deleteProductId);
                        boolean isDeleted = productService.deleteProduct(deleteId);

                        if (isDeleted) {
                            System.out.println("Product deleted successfully.");
                        } else {
                            System.out.println("Failed to delete the product.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid product ID. Please enter a valid integer.");
                    }
                    break;

                case "6":
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (!userChoice.equals("6"));
        // Close the scanner
    }


}
