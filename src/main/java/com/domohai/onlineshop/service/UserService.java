package com.domohai.onlineshop.service;

import com.domohai.onlineshop.model.User;
import com.domohai.onlineshop.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User createUser(String id, String name, String email, String password, String role) {
        return null;
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User updateUser(String id, User user) {
        return userRepository.save(user);
    }
    
    public void deleteUser(ObjectId id) {
        userRepository.deleteById(id);
    }
}
