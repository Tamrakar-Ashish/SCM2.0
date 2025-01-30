package com.scm.scm20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    //User dashboard page
    @RequestMapping("/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }

    //User Profile page
    @RequestMapping("/profile")
    public String userProfile() {
        return "user/profile";
    }

    //User Profile page
    @RequestMapping("/logout")
    public String userLogout() {
        return "user/logout";
    }

    //User add contact page

    // user view contact page

    // User delete contact page

    // User edit contact page



}
