package com.example.LearningSpringBoot.Repository;

import com.example.LearningSpringBoot.Entity.Accounts;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
 
	@Query(value = "Select * FROM bank_db.Accounts WHERE Account_Num = ?1", nativeQuery = true)
	Accounts getAccountsByAccountNum(long accountNum);
	// public/private return ----- return --- methodname ----(parameter);
	
	@Query(value = "SELECT * FROM bank_db.Accounts WHERE Account_Type = ?1", nativeQuery = true)
	List<Accounts> getAccountsByAccountType(String accountType);
	
    @Query(value = "SELECT * FROM bank_db.Accounts WHERE Account_Balance >= ?1", nativeQuery = true)
    List<Accounts> getAccountsByAccountBalance(BigDecimal amount);
    
    @Query(value = "SELECT * FROM bank_db.Accounts WHERE Account_OpenedDate = ?1", nativeQuery = true)
    List<Accounts> getAccountsByAccountOpenedDate(LocalDate date);
    
    @Query(value = "SELECT * FROM bank_db.Accounts WHERE Cus_ID = ?1", nativeQuery = true)
    List<Accounts> getAccountsByCusId(int cusId);
    
    
}
