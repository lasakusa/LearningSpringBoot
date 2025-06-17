package com.example.LearningSpringBoot.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LearningSpringBoot.Entity.Transaction;
import com.example.LearningSpringBoot.Repository.TransactionRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
	
	@Autowired
    private TransactionRepository transactionRepository;
	
	//getAllTransaction
	@GetMapping("/getAllTransaction")
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }
	
	@Operation(summary = "get Transaction by Transaction ID")
	@ApiResponses (value = {
		    @ApiResponse(responseCode = "200", description = "Transaction found"),
		    @ApiResponse(responseCode = "204", description = "No content"),
		    @ApiResponse(responseCode = "400", description = "Bad request"),
		    @ApiResponse(responseCode = "404", description = "Transaction not found"),
		    @ApiResponse(responseCode = "500", description = "Internal server error")
	})
	
	//get transaction by transaction ID
	@GetMapping("/getTransactionByTransactionID")
	public ResponseEntity<Transaction> getTransactionByTransactionID(long transactionID) {
		Transaction getTransactionByTransactionId = transactionRepository.getTransactionByTransactionID(transactionID);
		if(getTransactionByTransactionId == null) {
			return new ResponseEntity<Transaction>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Transaction>(getTransactionByTransactionId, HttpStatus.OK);
	}
	
	//get transaction by transaction type
	@GetMapping("/getTransactionByTransactionType")
	public List<Transaction> getTransactionByTransactionType(String transactionType) {
		return transactionRepository.getTransactionByTransactionType(transactionType);
	}
	
	//get transaction by transaction Date
	@GetMapping("/getTransactionByTransactionDate")
	public List<Transaction> getTransactionByDate(String transactionDate) {
		LocalDate date = LocalDate.parse(transactionDate);
		return transactionRepository.getTransactionByDate(date);
	}
	
	// get transaction by account number
	@GetMapping("/getTransactionByAccountNum")
	public List<Transaction> getTransactionByAccountNum(Long accountNum) {
		return transactionRepository.getTransactionByAccountNum(accountNum);
	}
	
	

}

