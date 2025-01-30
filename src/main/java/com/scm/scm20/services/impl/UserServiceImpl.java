package com.scm.scm20.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scm.scm20.entities.User;
import com.scm.scm20.helpers.AppConstants;
import com.scm.scm20.repositories.UserRepo;
import com.scm.scm20.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        // Check for unique email
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            logger.error("Email already exists: " + user.getEmail());
            throw new IllegalArgumentException("Email already in use");
        }

        // Generate user ID
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        // Password encode
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set the user role
        user.setRoleList(List.of(AppConstants.ROLE_USER));

        logger.info("User registered: " + user.getEmail());
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> existingUser = userRepo.findById(user.getUserId());
        return userRepo.save(user);
    }
    @Override
    public boolean isUserExist(String userId) {
        return userRepo.existsById(userId);
    }

    
}
