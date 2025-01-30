package com.scm.scm20.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.scm20.services.impl.SecurityCustomUserDetailsService;

@Configuration

public class SecurityConfiguration {

    // @Bean
    // public UserDetailsService userDetailsService() {

    //     //User create and login using java code in memory service

    //     UserDetails user1 = User
    //     .withUsername("Ashish")
    //     .password("1234")
    //     .roles("user","Asmin")
    //     .build();     
    // }

    //Dao Authentication
    //Configuration of authentication provider

    @Autowired
    private SecurityCustomUserDetailsService userDetailsService;
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        //Configuration
        //URL configuration which one should be public and which one should be private
        httpSecurity.authorizeHttpRequests(authorize->{
            authorize.requestMatchers("/user/**").authenticated();
            authorize.anyRequest().permitAll();
        });

        //Defalt login form
        //Any login form related changes will done here
        httpSecurity.formLogin(formLogin->{
            formLogin.loginPage("/login");
            formLogin.loginProcessingUrl("/authenticate");
            // formLogin.defaultSuccessUrl("/home");
            formLogin.successForwardUrl("/user/dashboard");
            formLogin.failureForwardUrl("/login?error");
            formLogin.usernameParameter("email");
            formLogin.passwordParameter("password");
        
        });

        httpSecurity.logout(logoutForm->  {
            logoutForm.logoutUrl("/do-logout");
        
            System.out.println("logout succesfull");
            logoutForm.logoutSuccessUrl("/login");
    
        });

        return httpSecurity.build();
    }
       
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
