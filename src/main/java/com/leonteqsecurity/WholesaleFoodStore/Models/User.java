package com.leonteqsecurity.WholesaleFoodStore.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
