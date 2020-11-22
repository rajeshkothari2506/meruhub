package com.meru.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meru.customer.exception.CustomerNotFoundException;
import com.meru.customer.model.Customer;
import com.meru.customer.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		if (customer == null) {
			throw new CustomerNotFoundException("Customer Doesn't exists with valid parameter ");
		}

		return customerRepository.save(customer);
	}

	@Override
	public Customer findCustomerByID(int id) {
		Optional<Customer> customer = customerRepository.findById(id);

		if (!customer.isPresent()) {
			throw new CustomerNotFoundException("Customer Doesn't exists for customer  ID " + id);
		}
		return customer.get();
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomerInformation(Customer customer) {
		findCustomerByID(customer.getId());// to check if customer exist of not for id
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerByID(int id) {
		findCustomerByID(id);
		customerRepository.deleteById(id);
		
	}

	@Override
	public void deleteAllCustomer() {
		customerRepository.deleteAll();
		
	}

	@Override
	public List<Customer> findCustomerByFirstName(String customerName) {
	/*	List<Customer> listOfAllCustomer = customerRepository.findByCustomerFirstName(customerName);
		if (listOfAllCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer Not Found with Name : " + customerName);
		}
		return listOfAllCustomer;*/
		return null;

	}
	
	
	
}
