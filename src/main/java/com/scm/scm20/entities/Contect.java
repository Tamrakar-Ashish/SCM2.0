package com.scm.scm20.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Contect {

    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Column(length = 1000)
    private String description;
    private boolean favorite=false;

    private String webLink;
    private  String linkedInLink;
    // private List<SocialLink> socialLinks=new ArrayList<>();
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contect",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
   private List<SocialLink> links=new ArrayList<>();
}

