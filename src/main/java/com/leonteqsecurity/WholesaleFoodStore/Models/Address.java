package com.leonteqsecurity.WholesaleFoodStore.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String country;
    private String postCode;
}
