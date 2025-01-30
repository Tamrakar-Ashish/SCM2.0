package com.scm.scm20.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scm.scm20.repositories.UserRepo;

@Service
public class SecurityCustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;
    // @Autowired
    // private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Implement your logic to load user by username
        
        System.out.println(userRepo.findByEmail(email));
      
        return userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("invalid usernaem or password"));
    }

}
