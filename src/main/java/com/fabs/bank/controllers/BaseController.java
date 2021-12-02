package com.fabs.bank.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

	@RequestMapping(method=RequestMethod.GET, value="/")
	public ResponseEntity<String>  getAppStatus() {
		return ResponseEntity.ok("Application is running...");
	}
}
