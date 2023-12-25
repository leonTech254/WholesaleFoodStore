package com.leonteqsecurity.WholesaleFoodStore.Repository.Interface;

import com.leonteqsecurity.WholesaleFoodStore.Models.User;

import java.util.List;

public interface UserDAO {
    List<User> findAllUsers();
    User findUser(long userId);
    boolean deleteUser(long userId);
    boolean updateUser(User user);
    boolean addUser(User user);
}
