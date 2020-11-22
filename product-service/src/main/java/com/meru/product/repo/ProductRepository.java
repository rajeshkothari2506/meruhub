package com.meru.product.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.meru.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByProductName(String  productName);
}
