package com.leonteqsecurity.WholesaleFoodStore.Respository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM customers", nativeQuery = true)
    List<Customer> findAllCustomers();

    @Query(value = "SELECT * FROM customers WHERE customerID = ?", nativeQuery = true)
    Customer findCustomer(int customerId);

    @Modifying
    @Query(value = "DELETE FROM customers WHERE customerID = ?", nativeQuery = true)
    boolean deleteCustomer(int customerId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE customers SET businessName = ?, address_line1 = ?, address_line2 = ?, address_line3 = ?, country = ?, postCode = ?, telephoneNumber = ? WHERE customerID = ?", nativeQuery = true)
    boolean updateCustomer(String businessName, String addressLine1, String addressLine2, String addressLine3, String country, String postCode, String telephoneNumber, int customerId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customers (businessName, address_line1, address_line2, address_line3, country, postCode, telephoneNumber) VALUES (?, ?, ?, ?, ?, ?, ?)", nativeQuery = true)
    void addCustomer(String businessName, String addressLine1, String addressLine2, String addressLine3, String country, String postCode, String telephoneNumber);
}
