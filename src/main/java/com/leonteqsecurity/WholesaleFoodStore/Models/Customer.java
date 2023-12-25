package com.leonteqsecurity.WholesaleFoodStore.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerID;
    private String businessName;
    private Address address;
    private String telephoneNumber;
}
