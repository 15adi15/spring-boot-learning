package com.example.oAuth2.__MasterClass.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    private String email;
    private String provider;
    private String providerSubject;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public User(String userName, String email, String provider, String providerSubject) {
        this.userName = userName;
        this.email = email;
        this.provider = provider;
        this.providerSubject = providerSubject;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public User() {
    }
    public String getProvider() {
        return provider;
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }
    public String getProviderSubject() {
        return providerSubject;
    }
    public void setProviderSubject(String providerSubject) {
        this.providerSubject = providerSubject;
    }

    
 
}
