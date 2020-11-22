package com.meru.composite.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "order_service")
public class OrderStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String orderStatus;
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "cart_id", nullable = false)	
	private Cart cartId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Cart getCartId() {
		return cartId;
	}

	public void setCartId(Cart cartId) {
		this.cartId = cartId;
	}
	
	
}
