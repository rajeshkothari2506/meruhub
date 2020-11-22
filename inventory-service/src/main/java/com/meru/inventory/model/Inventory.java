package com.meru.inventory.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int availableInventory;
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "product_id", nullable = false)
	//@JsonIgnore
	private Product productId;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public int getAvailableInventory() {
		return availableInventory;
	}

	public void setAvailableInventory(int availableInventory) {
		this.availableInventory = availableInventory;
	}
	
	
	
	
}
