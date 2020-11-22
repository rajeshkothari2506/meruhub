package com.meru.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meru.cart.model.CartDetails;

public interface CartDetailsRepository extends JpaRepository<CartDetails, Integer>{

}
