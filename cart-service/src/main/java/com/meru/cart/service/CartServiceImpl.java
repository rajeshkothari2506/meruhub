package com.meru.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meru.cart.model.Cart;
import com.meru.cart.model.CartDetails;
import com.meru.cart.repo.CartDetailsRepository;
import com.meru.cart.repo.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	CartDetailsRepository cartDetailsRepository;
	
	@Override
	public Cart createCart(Cart cart) {
		return cartRepo.save(cart);
		
		
	}

	@Override
	public CartDetails addItemToCart(CartDetails cartService) {
		CartDetails cartDetails = cartDetailsRepository.save(cartService);	
		return cartDetails;
	}

}
