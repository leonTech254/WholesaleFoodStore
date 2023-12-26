package com.leonteqsecurity.WholesaleFoodStore.Service;

import com.leonteqsecurity.WholesaleFoodStore.Models.Customer;
import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

/**
 * Service class for managing Customer entities in the Wholesale Food Store application.
 */
@Service
public class CustomerServices {

    private final CustomerRepository customerRepository;

    /**
     * Constructor for CustomerServices.
     *
     * @param customerRepository The repository for managing Customer entities.
     */
    @Autowired
    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Retrieves all customers from the repository.
     *
     * @return List of all customers.
     */
    public List<Customer> findAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    /**
     * Finds a customer by their ID.
     *
     * @param customerId The ID of the customer to find.
     * @return The found customer or null if not found.
     */
    public Customer findCustomer(int customerId) {
        return customerRepository.findCustomer(customerId);
    }

    /**
     * Deletes a customer by their ID.
     *
     * @param customerId The ID of the customer to delete.
     * @return True if the customer is deleted, false otherwise.
     */
    public boolean deleteCustomer(int customerId) {
        return customerRepository.deleteCustomer(customerId);
    }

    /**
     * Updates a customer in the repository.
     *
     * @param customer The customer with updated information.
     * @return True if the customer is updated, false otherwise.
     */
    @Transactional
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(
                customer.getBusinessName(),
                customer.getAddress().getAddressLine1(),
                customer.getAddress().getAddressLine2(),
                customer.getAddress().getAddressLine3(),
                customer.getAddress().getCountry(),
                customer.getAddress().getPostCode(),
                customer.getTelephoneNumber(),
                customer.getCustomerID()
        );
    }

    /**
     * Adds a new customer to the repository.
     *
     * @param customer The customer to add.
     * @return True if the customer is added, false otherwise.
     */
    @Transactional
    public boolean addCustomer(Customer customer) {
        customerRepository.addCustomer(
                customer.getBusinessName(),
                customer.getAddress().getAddressLine1(),
                customer.getAddress().getAddressLine2(),
                customer.getAddress().getAddressLine3(),
                customer.getAddress().getCountry(),
                customer.getAddress().getPostCode(),
                customer.getTelephoneNumber()
        );
        return true;
    }
}
