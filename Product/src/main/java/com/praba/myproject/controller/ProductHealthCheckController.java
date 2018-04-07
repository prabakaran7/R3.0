package com.praba.myproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductHealthCheckController {
	
	@GetMapping("/product/health-check")
	public ResponseEntity<String> getHealthCheck(){
		return new ResponseEntity<String>("healthy", HttpStatus.OK);
	}

}
