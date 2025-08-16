package com.example.LearningSpringBoot.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class accountsDTO {
    private Long accountNum;
    private String accountType;
    private BigDecimal accountBalance;
    private LocalDate accountOpenDate;

    // Constructor
    public accountsDTO(Long accountNum, String accountType, BigDecimal accountBalance, LocalDate accountOpenDate) {
        this.accountNum = accountNum;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.accountOpenDate = accountOpenDate;
    }

    // Getters and setters
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
}
