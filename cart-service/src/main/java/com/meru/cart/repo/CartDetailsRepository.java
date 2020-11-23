package com.meru.cart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meru.cart.model.Cart;
import com.meru.cart.model.CartDetails;

public interface CartDetailsRepository extends JpaRepository<CartDetails, Integer>{

	List<CartDetails> findByCartId(Cart cartId);
}
