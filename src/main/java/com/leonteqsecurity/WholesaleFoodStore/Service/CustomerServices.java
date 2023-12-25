package com.leonteqsecurity.WholesaleFoodStore.Service;

import com.leonteqsecurity.WholesaleFoodStore.Models.Customer;
import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServices {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    public Customer findCustomer(int customerId) {
        return customerRepository.findCustomer(customerId);
    }

    public boolean deleteCustomer(int customerId) {
        return customerRepository.deleteCustomer(customerId);
    }

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
