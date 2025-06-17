package com.example.LearningSpringBoot.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Transaction", schema = "bank_db")
public class Transaction {

    @Id
    @Column(name = "Transaction_ID")
    private Long transactionID;

    @Column(name = "Transaction_Type", length = 15)
    private String transactionType;

    @Column(name = "Transaction_Amount", precision = 15, scale = 2)
    private BigDecimal transactionAmount;

    @Column(name = "Transaction_Date")
    private LocalDate transactionDate;

    @ManyToOne
    @JoinColumn(name = "Account_Num")
    private Accounts account;

    // Constructors
    public Transaction() {}

    public Transaction(Long transactionID, String transactionType, BigDecimal transactionAmount, LocalDate transactionDate) {
        this.transactionID = transactionID;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    // Getters and Setters
    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }
}
