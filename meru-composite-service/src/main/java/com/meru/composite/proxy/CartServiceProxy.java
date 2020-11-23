package com.meru.composite.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.meru.composite.models.Cart;
import com.meru.composite.models.CartDetails;


@FeignClient(name = "cart-service")
public interface CartServiceProxy {

	@PostMapping("/createcart")
	public int createCart(@RequestBody Cart cart);
	
	@PostMapping("/addtocart")
	public int addItemToCart(@RequestBody CartDetails cartDetails);
	
	@GetMapping("/getcartbyid/{cartId}")
	public Cart getCartByID(@PathVariable int cartId);
	
	@GetMapping("/getcartdetails/{cartId}")
	public List<CartDetails> getCartDetailsOfId(@PathVariable int cartId); 
}
