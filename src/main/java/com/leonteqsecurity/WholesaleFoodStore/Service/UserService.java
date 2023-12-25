package com.leonteqsecurity.WholesaleFoodStore.Service;

import com.leonteqsecurity.WholesaleFoodStore.Models.Role;
import com.leonteqsecurity.WholesaleFoodStore.Models.User;
import com.leonteqsecurity.WholesaleFoodStore.Respository.Interface.UserRepository;
import com.leonteqsecurity.WholesaleFoodStore.Security.PasswordEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

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

    public User findUser(int userId) {
        return userRepository.findUser(userId);
    }

    public boolean deleteUser(Long userId) {
        return userRepository.deleteUser(userId);
    }

    public boolean updateUser(User user) {
        return userRepository.updateUser(user.getUsername(), user.getPassword(), user.getRole().name(), user.getId());
    }
    public boolean addUser(User user) {
        String rawPassword=user.getPassword();
        String EncrptedPassword= PasswordEncryption.encryptPassword(rawPassword);
        user.setPassword(EncrptedPassword);
        userRepository.addUser(user.getUsername(), user.getPassword(), String.valueOf(Role.User));
        return true;
    }

    public boolean loginUser(User user)
    {
        Optional<User> userOptional=userRepository.userlogin(user.getUsername());
        if(userOptional.isPresent())
        {
            User userDB=userOptional.get();
            return PasswordEncryption.validatePassword(user.getPassword(),userDB.getPassword());
        }else
        {
            return false;
        }
    }
}
