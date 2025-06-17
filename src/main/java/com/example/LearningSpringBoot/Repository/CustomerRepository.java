package com.example.LearningSpringBoot.Repository;

import com.example.LearningSpringBoot.Entity.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	//get customer by ID
	@Query(value = "Select * FROM bank_db.Customer WHERE Cus_ID = ?1", nativeQuery = true)
	Customer getCustomerByID(int CusID);
	// public/private return ----- return --- methodname ----(parameter);
	
	// Get customer by first name
    @Query(value = "SELECT * FROM bank_db.Customer WHERE Cus_FN = ?1", nativeQuery = true)
    List<Customer> getCustomersByCusFN(String firstName);
    // return type: List<Customer>
    // method name: getCustomersByCusFN
    // parameter: String firstName

    // Get customer by last name
    @Query(value = "SELECT * FROM bank_db.Customer WHERE Cus_LN = ?1", nativeQuery = true)
    List<Customer> getCustomersByCusLN(String lastName);

    // Get customer by city
    @Query(value = "SELECT * FROM bank_db.Customer WHERE Cus_City = ?1", nativeQuery = true)
    List<Customer> getCustomersByCusCity(String city);

    // Get customer by email
    @Query(value = "SELECT * FROM bank_db.Customer WHERE Cus_Email = ?1", nativeQuery = true)
    Customer getCustomerByCusEmail(String email);

    // Get all customers from a specific state
    @Query(value = "SELECT * FROM bank_db.Customer WHERE Cus_State = ?1", nativeQuery = true)
    List<Customer> getCustomersByCusState(String state);
}
