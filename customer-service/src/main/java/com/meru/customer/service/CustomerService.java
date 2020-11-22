package com.meru.customer.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.meru.customer.model.Customer;

@Component
public interface CustomerService {

	Customer saveCustomer(Customer customer);
	Customer findCustomerByID(int id);
	public List<Customer> getAllCustomer();
	public Customer updateCustomerInformation(Customer customer);
	public void deleteCustomerByID(int id);
	public void deleteAllCustomer();
	List<Customer> findCustomerByFirstName(String customerName);	
	//public List<Customer> findCustomerByAddress(String customerAddress);

}
