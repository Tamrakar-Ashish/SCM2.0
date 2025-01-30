package com.scm.scm20.services;

import java.util.List;
import java.util.Optional;

import com.scm.scm20.entities.User;

public interface UserService {

    User saveUser(User user);

    Optional<User> getUserById(String id);
    
    List<User> getAllUsers();

    void deleteUser(String id);

    User updateUser(User user);

    boolean isUserExist(String userId);

    // add more method to related to user services
    
    }

