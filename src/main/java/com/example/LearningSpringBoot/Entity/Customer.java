package com.example.LearningSpringBoot.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Customer", schema = "bank_db")
public class Customer {

    @Id
    @Column(name = "Cus_ID")
    private Integer cusID;

    @Column(name = "Cus_FN", nullable = false)
    private String cusFN;

    @Column(name = "Cus_LN")
    private String cusLN;

    @Column(name = "Cus_DOB")
    private LocalDate DOB;

    @Column(name = "Cus_Email")
    private String email;

    @Column(name = "Cus_LineAddress")
    private String address;

    @Column(name = "Cus_City")
    private String city;

    @Column(name = "Cus_State", length = 10)
    private String state;

    @Column(name = "Cus_Zip", length = 10)
    private String zip;

    // Constructors
    public Customer() {}  // Required by JPA

    public Customer(Integer cusID, String cusFN, String cusLN, LocalDate dOB, String email,
                    String address, String city, String state, String zip) {
        this.cusID = cusID;
        this.cusFN = cusFN;
        this.cusLN = cusLN;
        this.DOB = dOB;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Getters and Setters
    public Integer getCusID() {
        return cusID;
    }

    public void setCusID(Integer cusID) {
        this.cusID = cusID;
    }

    public String getCusFN() {
        return cusFN;
    }

    public void setCusFN(String cusFN) {
        this.cusFN = cusFN;
    }

    public String getCusLN() {
        return cusLN;
    }

    public void setCusLN(String cusLN) {
        this.cusLN = cusLN;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate dOB) {
        this.DOB = dOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
