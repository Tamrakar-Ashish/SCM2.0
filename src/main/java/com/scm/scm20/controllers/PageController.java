package com.scm.scm20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class PageController {

    @RequestMapping("/home")
    public String home() {

        return "home";
    }
    
    @RequestMapping("/about")
    public String about(){

        return "about";
    }
    
    @RequestMapping("/services")
    public String services(){

        return "services";
    }

    @RequestMapping("/register")
    public String register(){

        return "register";
    }

    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    @RequestMapping("/contact")
    public String contact(){

        return "contact";
    }

}
