package com.meru.customer.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meru.customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
	//List<Customer> findByCustomerFirstName(String  customerName);
}
