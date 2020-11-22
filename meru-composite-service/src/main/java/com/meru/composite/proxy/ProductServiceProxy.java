package com.meru.composite.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meru.composite.models.Product;



@FeignClient(name = "product-service")
public interface ProductServiceProxy {

	@PostMapping("/addproduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product);
	
	@GetMapping("/getallproducts") 
	public ResponseEntity<List<Product>> getAllProducts();
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product>getProductByID(@PathVariable int id);
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<String>deleteAllProduct();
	
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String>deleteProductByID(@PathVariable int id);
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product Product );
	
	@GetMapping("/productbyname/{productName}")
	public ResponseEntity<List<Product>> getAllProductByName(@PathVariable String productName);
	
	
	
	
}
