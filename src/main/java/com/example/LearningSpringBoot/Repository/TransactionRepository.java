package com.example.LearningSpringBoot.Repository;

import com.example.LearningSpringBoot.Entity.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
 
	@Query(value = "Select * FROM bank_db.Transaction WHERE Transaction_ID = ?1", nativeQuery = true)
	Transaction getTransactionByTransactionID(long transactionID);
	// public/private return ----- return --- methodname ----(parameter);
	
	@Query(value = "SELECT * FROM bank_db.Transaction WHERE Transaction_Type = ?1", nativeQuery = true)
	List<Transaction> getTransactionByTransactionType(String transactionType);
	
    @Query(value = "SELECT * FROM bank_db.Transaction WHERE Transaction_Amount >= ?1", nativeQuery = true)
    List<Transaction> getTransactionByTransactionAmount(BigDecimal transactionAmount);
    
    @Query(value = "SELECT * FROM bank_db.Transaction WHERE Transaction_Date = ?1", nativeQuery = true)
    List<Transaction> getTransactionByDate(LocalDate transactionDate);
    
    @Query(value = "SELECT * FROM bank_db.Transaction WHERE Account_Num = ?1", nativeQuery = true)
    List<Transaction> getTransactionByAccountNum(Long accountNum);
    
    
}
