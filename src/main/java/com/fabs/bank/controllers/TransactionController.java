package com.fabs.bank.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fabs.bank.dto.EncryptedTransactionRequest;

@RestController
@RequestMapping("/transaction")
@Validated
public class TransactionController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/")
	public ResponseEntity<String> executeTransaction(@Valid @RequestBody EncryptedTransactionRequest transactionRequest) throws Exception {
		return ResponseEntity.ok("Transaction successful!");
	}
}
