package com.meru.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meru.customer.model.Customer;
import com.meru.customer.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	

	@GetMapping("/hello")
	public String hello() {
		return "Hello Customer";
	}
	
	
   @PostMapping("/add")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {		
		Customer cust = customerService.saveCustomer(customer);		
		return new ResponseEntity<String>("Customer Account is created with Account No : "+cust.getId(),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> allCustomer = customerService.getAllCustomer();
		return new ResponseEntity<List<Customer>>(allCustomer,HttpStatus.FOUND);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer>getCustomerByID(@PathVariable int id){
		return new ResponseEntity<Customer>(customerService.findCustomerByID(id),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<String>deleteAllCustomer(){
		customerService.deleteAllCustomer();
		return new ResponseEntity<String>("All Customer are Removed From Bank",HttpStatus.FOUND);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String>deleteCustomerByID(@PathVariable int id){
		customerService.deleteCustomerByID(id);
		return new ResponseEntity<String>("Customer is Deleted With Account ID "+id,HttpStatus.FOUND);
	}
	
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer )
	{
		return customerService.updateCustomerInformation(customer);
		//return null;
	}
	
	
	@GetMapping("/custbyfirstname/{customerName}")
	public ResponseEntity<List<Customer>> getAllCustomerByName(@PathVariable String customerName){
		List<Customer> allCustomer = customerService.findCustomerByFirstName(customerName);
		return new ResponseEntity<List<Customer>>(allCustomer,HttpStatus.FOUND);
	}
	
	
}
