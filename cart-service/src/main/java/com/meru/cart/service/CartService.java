package com.meru.cart.service;

import com.meru.cart.model.Cart;
import com.meru.cart.model.CartDetails;

public interface CartService {

	public Cart createCart(Cart cart);
	public CartDetails addItemToCart(CartDetails cartService);
}
