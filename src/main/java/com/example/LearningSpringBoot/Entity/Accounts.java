package com.example.LearningSpringBoot.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Accounts", schema = "bank_db")
public class Accounts {

    @Id
    @Column(name = "Account_Num", precision = 20)
    private Long accountNum;

    @Column(name = "Account_Type", length = 15)
    private String accountType;

    @Column(name = "Account_Balance", precision = 15, scale = 2)
    private BigDecimal accountBalance;

    @Column(name = "Account_OpenedDate")
    private LocalDate accountOpenDate;

    @ManyToOne
    @JoinColumn(name = "Cus_ID")
    private Customer customer;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    // Constructors
    public Accounts() {}

    public Accounts(Long accountNum, String accountType, BigDecimal accountBalance, LocalDate accountOpenDate) {
        this.accountNum = accountNum;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.accountOpenDate = accountOpenDate;
    }

    // Getters and Setters
    public Long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Long accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public LocalDate getAccountOpenDate() {
        return accountOpenDate;
    }

    public void setAccountOpenDate(LocalDate accountOpenDate) {
        this.accountOpenDate = accountOpenDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
