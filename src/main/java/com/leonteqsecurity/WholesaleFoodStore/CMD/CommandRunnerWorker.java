package com.leonteqsecurity.WholesaleFoodStore.CMD;

import com.leonteqsecurity.WholesaleFoodStore.Models.FoodProduct;
import com.leonteqsecurity.WholesaleFoodStore.Service.FoodProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
@AllArgsConstructor
public class CommandRunnerWorker implements CommandLineRunner {
   private final CustomerServiceCommandRunner customerServiceCommandRunner;
   private  final  ProductServiceCommandRunner productServiceCommandRunner;

    @Override
    public void run(String... args) throws Exception {
        // Your interactive command logic goes here
        System.out.println("THE FOOD STORE\nChoose from these options");
        System.out.println("__________________________________________");
        HashMap<Integer, String> userMenu = new HashMap<>();
        userMenu.put(1, "Customer Module");
        userMenu.put(2, "Product Module");
        userMenu.put(3, "Exit Program");

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
                    productServiceCommandRunner.runMenu();
                    break;
                case "2":
                    customerServiceCommandRunner.runMenus();

                case "3":
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (!userChoice.equals("3"));
        // Close the scanner
        scanner.close();
    }
}
