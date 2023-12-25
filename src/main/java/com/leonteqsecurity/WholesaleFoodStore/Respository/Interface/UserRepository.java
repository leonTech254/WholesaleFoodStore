package com.leonteqsecurity.WholesaleFoodStore.Respository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<User> findAllUsers();

    @Query(value = "SELECT * FROM users WHERE id = :userId", nativeQuery = true)
    User findUser(@Param("userId") int userId);
    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)

    Optional<User> userlogin(@Param("username") String username);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE id = :userId", nativeQuery = true)
    boolean deleteUser(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET username = :username, password = :password, role = :role WHERE id = :userId", nativeQuery = true)
    boolean updateUser(@Param("username") String username, @Param("password") String password, @Param("role") String role, @Param("userId") int userId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (username, password, role) VALUES (:username, :password, :role)", nativeQuery = true)
    void addUser(@Param("username") String username, @Param("password") String password, @Param("role") String role);
}
