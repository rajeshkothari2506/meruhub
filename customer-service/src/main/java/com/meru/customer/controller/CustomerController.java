package com.meru.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {


	@GetMapping("/hello")
	public String hello() {
		return "Hello Customer";
	}
}
