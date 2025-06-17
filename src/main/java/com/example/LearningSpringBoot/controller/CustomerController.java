package com.example.LearningSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.LearningSpringBoot.Entity.Customer;
import com.example.LearningSpringBoot.Repository.CustomerRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Get all customers
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customers by first name
    @GetMapping("/get-Customers-By-FirstName")
    public List<Customer> getCustomersByCusFN(@RequestParam String firstName) {
        return customerRepository.getCustomersByCusFN(firstName);
    }

    // Get customers by last name
    @GetMapping("/get-Customers-By-LastName")
    public List<Customer> getCustomersByCusLN(@RequestParam String lastName) {
        return customerRepository.getCustomersByCusLN(lastName);
    }

    // Get customers by city
    @GetMapping("/get-Customers-By-City")
    public List<Customer> getCustomersByCusCity(@RequestParam String city) {
        return customerRepository.getCustomersByCusCity(city);
    }

    @Operation(summary = "get customer by email")
    @ApiResponses(value = {
    	    @ApiResponse(responseCode = "200", description = "Customer found"),
		    @ApiResponse(responseCode = "204", description = "No content"),
		    @ApiResponse(responseCode = "400", description = "Bad request"),
		    @ApiResponse(responseCode = "404", description = "Customer not found"),
		    @ApiResponse(responseCode = "500", description = "Internal server error")
	})

    
    // Get customer by email
    @GetMapping("/get-Customer-By-Email")
    public ResponseEntity<Customer> getCustomerByCusEmail(@RequestParam String email) {
    	Customer getCustomerByEmail = customerRepository.getCustomerByCusEmail(email);
    	if (getCustomerByEmail == null){
    		return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<Customer>(getCustomerByEmail, HttpStatus.OK);
    }

    
    // Get customers by state
    @GetMapping("/get-Customers-By-State")
    public List<Customer> getCustomersByCusState(@RequestParam String state) {
        return customerRepository.getCustomersByCusState(state);
    }
}
