package com.meru.product.service;

import java.util.List;

import com.meru.product.model.Product;

public interface ProductService {

	Product saveProduct(Product product);
	Product findProductByID(int id);
	public List<Product> getAllProduct();
	public Product updateProductInformation(Product product);
	public void deleteProductByID(int id);
	public void deleteAllProduct();	
	List<Product> findProductByProductName(String productName);
}
