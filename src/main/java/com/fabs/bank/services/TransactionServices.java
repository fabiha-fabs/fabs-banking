package com.fabs.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fabs.bank.dto.EncryptedTransactionRequest;
import com.fabs.bank.dto.DecryptedTransactionResponse;

@Service
public class TransactionServices {
	@Autowired
	private RestTemplate restTemplate;

	public void makeTransaction(EncryptedTransactionRequest transactionRequest) {
		DecryptedTransactionResponse decryptedTransactionRequest = restTemplate.postForObject(
				"http://localhost:8282/base64/decode", transactionRequest, DecryptedTransactionResponse.class);
		
	}
}
