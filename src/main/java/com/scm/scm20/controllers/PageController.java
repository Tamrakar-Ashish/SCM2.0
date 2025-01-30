package com.scm.scm20.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.scm20.entities.User;
import com.scm.scm20.forms.UserForm;
import com.scm.scm20.services.UserService;

import jakarta.validation.Valid;




@Controller
public class PageController {

    @Autowired
    private UserService userService;

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

    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    @RequestMapping("/contact")
    public String contact(){

        return "contact";
    }

    @RequestMapping("/register")
    public String register(Model model){

        UserForm userForm=new UserForm();
        // userForm.setName("Ashish");
        // userForm.setEmail("ashish123@gmail.com");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bResult){
       System.out.println("register compleate");
       //Fetch form data
       System.out.println(userForm);
       //Validate form data
       if(bResult.hasErrors()){
        return "register";
        }
       //save to database
       User user=User.builder()
       .name(userForm.getName())
       .email(userForm.getEmail())
       .password(userForm.getPassword())
       .phoneNumber(userForm.getPhoneNumber())
       .about(userForm.getAbout())
       .profilePic("https://www.bing.com/images/search?view=detailV2&ccid=JDa%2f")
       .enabled(true)
       .build();
    


    //    User user=new User();
    //    user.setName(userForm.getName());
    //    user.setEmail(userForm.getEmail());
    //    user.setPassword(userForm.getPassword());
    //    user.setPhoneNumber(userForm.getPhoneNumber());
    //    user.setAbout(userForm.getAbout());   
    //    user.setProfilePic("https://www.bing.com/images/search?view=detailV2&ccid=JDa%2f");
       userService.saveUser(user);
       //message ="Registration Successful"
       //redurect login page
        return"redirect:/register";
    }
}
