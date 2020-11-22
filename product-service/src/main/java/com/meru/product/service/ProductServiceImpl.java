package com.meru.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.meru.product.model.Product;
import com.meru.product.repo.ProductRepository;

@Repository
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findProductByID(int id) {
		Optional<Product> product = productRepository.findById(id);		
		return product.get();
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product updateProductInformation(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProductByID(int id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public void deleteAllProduct() {
		productRepository.deleteAll();
		
	}

	@Override
	public List<Product> findProductByProductName(String productName) {
		// TODO Auto-generated method stub
		return productRepository.findByProductName(productName);
	}

}
