package com.meru.customer.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(name = "emai_address",nullable = false)	
	private String email;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@Column(name = "phone",nullable = false)
	private String contactDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<ShippingAddress> shippingAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<Stores> visitedStores;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<OrderHistory> orderHistory;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public List<ShippingAddress> getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(List<ShippingAddress> shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<Stores> getVisitedStores() {
		return visitedStores;
	}

	public void setVisitedStores(List<Stores> visitedStores) {
		this.visitedStores = visitedStores;
	}

	public List<OrderHistory> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(List<OrderHistory> orderHistory) {
		this.orderHistory = orderHistory;
	}
	
	
}
