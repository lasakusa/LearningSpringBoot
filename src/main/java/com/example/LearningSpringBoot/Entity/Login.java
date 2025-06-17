package com.example.LearningSpringBoot.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Login", schema = "bank_db")
public class Login {

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @OneToOne
    @JoinColumn(name = "Cus_ID")
    private Customer customer;

    // Constructors
    public Login() {}

    public Login(String username, String passwordHash, Customer customer) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.customer = customer;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
