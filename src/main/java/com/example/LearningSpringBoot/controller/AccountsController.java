package com.example.LearningSpringBoot.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.LearningSpringBoot.Entity.Accounts;
import com.example.LearningSpringBoot.Repository.AccountsRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
	
	@Autowired
    private AccountsRepository accountsRepository;
	
	@Operation(summary = "get Account By Account Number")
	@ApiResponses (value = {
			@ApiResponse(responseCode = "200", description = "Account found"),
			@ApiResponse(responseCode = "204", description = "No content"),
		    @ApiResponse(responseCode = "400", description = "Bad request"),
		    @ApiResponse(responseCode = "404", description = "Account not found"),
		    @ApiResponse(responseCode = "500", description = "Internal server error")			
	})
	
	//getAllAccounts
	@GetMapping("/getAllAccounts")
    public List<Accounts> getAllAccounts() {
        return accountsRepository.findAll();
    }
	
	//get account by account number
	@GetMapping("/get-Account-By-AccountNum")
	public ResponseEntity<Accounts> getAccountsByAccountNum(long accountNum) {
		Accounts getAccountsByAccountsNum = accountsRepository.getAccountsByAccountNum(accountNum);
		if (getAccountsByAccountsNum == null) {
			return new ResponseEntity<Accounts>(HttpStatus.NO_CONTENT);
				}
		return new ResponseEntity<Accounts>(getAccountsByAccountsNum, HttpStatus.OK);
	}
		
	//get account by account type
	@GetMapping("/get-Account-By-AccountType")
	public List<Accounts> getAccountsByAccountType(String accountType) {
		return accountsRepository.getAccountsByAccountType(accountType);
	}
	
	//get account by account openedDate
	@GetMapping("/get-Account-By-AccountOpenedDate")
	public List<Accounts> getAccountsByAccountOpenedDate(String accountOpenDate) {
		LocalDate openDate = LocalDate.parse(accountOpenDate);
		return accountsRepository.getAccountsByAccountOpenedDate(openDate);
	}
	
	// get accounts by customer ID
	@GetMapping("/get-Accounts-By-CustomerID")
	public List<Accounts> getAccountsByCusId(int cusId) {
		return accountsRepository.getAccountsByCusId(cusId);
	}
	
	@PostMapping("/addAccount")
	@Operation(summary = "add a new account")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Account created"),
			@ApiResponse(responseCode = "400", description = "Invalid Input"),
		    @ApiResponse(responseCode = "500", description = "server error"),
	})
	
	public ResponseEntity<Accounts> addAccount(@RequestBody Accounts accounts) {
		try {
			Accounts savedAccounts = accountsRepository.save(accounts);
			return new ResponseEntity<>(savedAccounts, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
			// TODO: handle exception
		}
		
	
}

