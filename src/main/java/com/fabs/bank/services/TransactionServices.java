package com.fabs.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionServices {
	@Autowired
	private RestTemplate restTemplate;

}
