package com.scm.scm20.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
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
public class User implements UserDetails{
   
   @Id
   private String userId;
   @Column(nullable = false)
   private String name;
   @Column(nullable = false, unique = true)
   private String email;
   @Getter(value = AccessLevel.NONE)
   private String password;
   @Column(length = 1000)
   private String about;
   @Column(length = 1000)
   private String profilePic;
   private String phoneNumber;

   // information
   @Column(nullable = false)
   private boolean enabled=true;
   private boolean emailVerified;
   private boolean profileverified;

   //SELF GOOGLE,TWITTER, FACEBOOK, LINKEDIN, GITHUB
   @Enumerated(value = EnumType.STRING)
   private Providers provider=Providers.SELF;
   private String providerUserId;

   //add other more fields if needed
   @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
   private List<Contect> contects=new ArrayList<>();

   @ElementCollection(fetch=FetchType.EAGER)
   private List<String> roleList= new ArrayList<>();

   // UserDetails interface implementation method

   //Its dumy implementation
   @Override
   //List of role{User, Admin}
   //Converted into collection of simple Grand authoruty
   public Collection<? extends GrantedAuthority> getAuthorities() {
      Collection<SimpleGrantedAuthority> roles = roleList.stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
      return roles;
   }

   @Override
   public String getUsername() {
      return this.email;
   }

   @Override
   public String getPassword() {
      return this.password;
   }


	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

// 	@Override
// 	public boolean isAccountNonExpired() {
// 		return this.accountNonExpired;
// 	}

// 	@Override
// 	public boolean isAccountNonLocked() {
// 		return this.accountNonLocked;
// 	}

// 	@Override
// 	public boolean isCredentialsNonExpired() {
// 		return this.credentialsNonExpired;
// 	}

// 	@Override
// 	public void eraseCredentials() {
// 		this.password = null;
// 	}
   }
   
