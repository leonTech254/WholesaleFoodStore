package com.leonteqsecurity.WholesaleFoodStore.Respository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.Customer;

import java.util.List;

/**
 * Data Access Object (DAO) interface for interacting with customer data in the Wholesale Food Store application.
 */
public interface CustomerDAO {

    /**
     * Retrieves a list of all customers.
     *
     * @return A list containing all customers.
     */
    List<Customer> findAllCustomers();

    /**
     * Finds a customer by their unique identifier.
     *
     * @param customerId The unique identifier of the customer to find.
     * @return The customer with the specified identifier, or null if not found.
     */
    Customer findCustomer(int customerId);

    /**
     * Deletes a customer by their unique identifier.
     *
     * @param customerId The unique identifier of the customer to delete.
     * @return true if the customer was successfully deleted, false otherwise.
     */
    boolean deleteCustomer(int customerId);

    /**
     * Updates the information of an existing customer.
     *
     * @param customer The customer object containing updated information.
     * @return true if the customer was successfully updated, false otherwise.
     */
    boolean updateCustomer(Customer customer);

    /**
     * Adds a new customer to the data store.
     *
     * @param customer The customer object to add.
     * @return true if the customer was successfully added, false otherwise.
     */
    boolean addCustomer(Customer customer);
}
