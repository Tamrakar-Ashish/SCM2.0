package com.scm.scm20.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
   
   @Id
   private String userId;
   @Column(nullable = false)
   private String name;
   @Column(nullable = false, unique = true)
   private String email;
   private String password;
   @Column(length = 1000)
   private String about;
   @Column(length = 1000)
   private String profilePic;
   private String phoneNumber;

   // information
   private boolean enabled;
   private boolean emailVerified;
   private boolean profileverified;

   //SELF GOOGLE,TWITTER, FACEBOOK, LINKEDIN, GITHUB
   private Providers provider=Providers.SELF;
   private String providerUserId;

   //add other more fields if needed
   @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
   private List<Contect> contects=new ArrayList<>();
}
   
