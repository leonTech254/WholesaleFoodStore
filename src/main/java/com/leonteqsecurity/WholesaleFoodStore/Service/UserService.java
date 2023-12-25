package com.leonteqsecurity.WholesaleFoodStore.Service;

import com.leonteqsecurity.WholesaleFoodStore.Models.User;
import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUser(Long userId) {
        return userRepository.findUser(userId);
    }

    public boolean deleteUser(Long userId) {
        return userRepository.deleteUser(userId);
    }

    public boolean updateUser(User user) {
        return userRepository.updateUser(user.getUsername(), user.getPassword(), user.getRole().name(), user.getId());
    }

    public boolean addUser(User user) {
        userRepository.addUser(user.getUsername(), user.getPassword(), user.getRole().name());
        return true;
    }
}
