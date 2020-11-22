package com.meru.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meru.cart.model.Cart;
import com.meru.cart.model.CartDetails;
import com.meru.cart.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Fro Cart Service";
	}
	
	@PostMapping("/createcart")
	public int createCart(@RequestBody Cart cart) {
		Cart createdCart = cartService.createCart(cart);
		return createdCart.getId();
	}
	
	@PostMapping("/addtocart")
	public int addItemToCart(@RequestBody CartDetails cartDetails) {
			//@PathVariable int cartid,@PathVariable int productid,@PathVariable int quantity) {
		CartDetails cart = cartService.addItemToCart(cartDetails);
		return cart.getId();
		
	}
}
