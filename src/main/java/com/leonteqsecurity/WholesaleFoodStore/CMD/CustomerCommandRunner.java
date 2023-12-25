package com.leonteqsecurity.WholesaleFoodStore.CMD;

import com.leonteqsecurity.WholesaleFoodStore.Models.Address;
import com.leonteqsecurity.WholesaleFoodStore.Models.Customer;
import com.leonteqsecurity.WholesaleFoodStore.Service.CustomerServices;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
@AllArgsConstructor
public class CustomerCommandRunner implements CommandLineRunner {

    private final CustomerServices customerServices;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CUSTOMER MANAGEMENT SYSTEM");
        System.out.println("Choose from these options");
        System.out.println("__________________________________________");

        HashMap<Integer, String> userMenu = new HashMap<>();
        userMenu.put(1, "List all customers");
        userMenu.put(2, "Search for customer by ID");
        userMenu.put(3, "Add a new Customer");
        userMenu.put(4, "Update a Customer By ID");
        userMenu.put(5, "Delete a customer by ID");
        userMenu.put(6, "Exit");

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
                    System.out.println("Listing all customers:");
                    customerServices.findAllCustomers().forEach(customer -> System.out.println(customer.toString()));
                    break;

                case "2":
                    System.out.println("Search customer by ID");
                    System.out.print("Enter customer ID: ");
                    String customerId = scanner.nextLine();
                    try {
                        int id = Integer.parseInt(customerId);
                        Customer foundCustomer = customerServices.findCustomer(id);

                        if (foundCustomer != null) {
                            System.out.println("Found customer: " + foundCustomer.toString());
                        } else {
                            System.out.println("Customer not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Choice");
                    }
                    break;

                case "3":
                    System.out.println("Add a new customer");
                    System.out.print("Enter business name: ");
                    String businessName = scanner.nextLine();

                    System.out.print("Enter address line 1: ");
                    String addressLine1 = scanner.nextLine();

                    System.out.print("Enter address line 2: ");
                    String addressLine2 = scanner.nextLine();

                    System.out.print("Enter address line 3: ");
                    String addressLine3 = scanner.nextLine();

                    System.out.print("Enter country: ");
                    String country = scanner.nextLine();

                    System.out.print("Enter post code: ");
                    String postCode = scanner.nextLine();

                    System.out.print("Enter telephone number: ");
                    String telephoneNumber = scanner.nextLine();

                    try {
                        Address address = new Address(addressLine1, addressLine2, addressLine3, country, postCode);
                        Customer newCustomer = new Customer(businessName, address, telephoneNumber);
                        boolean isAdded = customerServices.addCustomer(newCustomer);

                        if (isAdded) {
                            System.out.println("Customer added successfully.");
                        } else {
                            System.out.println("Failed to add the customer.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid telephone number. Please enter a valid number.");
                    }
                    break;

                case "4":
                    System.out.println("Update a customer by ID");
                    System.out.print("Enter customer ID: ");
                    String updateCustomerId = scanner.nextLine();

                    try {
                        int updateId = Integer.parseInt(updateCustomerId);

                        Customer existingCustomer = customerServices.findCustomer(updateId);
                        if (existingCustomer != null) {
                            System.out.println("Found customer: " + existingCustomer.toString());

                            System.out.print("Enter new business name (or press Enter to keep existing): ");
                            String newBusinessName = scanner.nextLine();

                            System.out.print("Enter new address line 1 (or press Enter to keep existing): ");
                            String newAddressLine1 = scanner.nextLine();

                            System.out.print("Enter new address line 2 (or press Enter to keep existing): ");
                            String newAddressLine2 = scanner.nextLine();

                            System.out.print("Enter new address line 3 (or press Enter to keep existing): ");
                            String newAddressLine3 = scanner.nextLine();

                            System.out.print("Enter new country (or press Enter to keep existing): ");
                            String newCountry = scanner.nextLine();

                            System.out.print("Enter new post code (or press Enter to keep existing): ");
                            String newPostCode = scanner.nextLine();

                            System.out.print("Enter new telephone number (or press Enter to keep existing): ");
                            String newTelephoneNumber = scanner.nextLine();

                            boolean isUpdated = customerServices.updateCustomer(
                                    new Customer(
                                            updateId,
                                            newBusinessName,
                                            new Address(newAddressLine1, newAddressLine2, newAddressLine3, newCountry, newPostCode),
                                            newTelephoneNumber
                                    )
                            );

                            if (isUpdated) {
                                System.out.println("Customer updated successfully.");
                            } else {
                                System.out.println("Failed to update the customer.");
                            }
                        } else {
                            System.out.println("Customer not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid customer ID. Please enter a valid integer.");
                    }
                    break;

                case "5":
                    System.out.println("Delete a customer by ID");
                    System.out.print("Enter customer ID: ");
                    String deleteCustomerId = scanner.nextLine();

                    try {
                        int deleteId = Integer.parseInt(deleteCustomerId);
                        boolean isDeleted = customerServices.deleteCustomer(deleteId);

                        if (isDeleted) {
                            System.out.println("Customer deleted successfully.");
                        } else {
                            System.out.println("Failed to delete the customer.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid customer ID. Please enter a valid integer.");
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
        scanner.close();
    }
}
