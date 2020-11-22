package com.meru.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meru.product.model.Product;
import com.meru.product.service.ProductService;

@RestController
public class ProductController {

	
	@Autowired
	ProductService productService;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello From Product Service";
	}
	
	 @PostMapping("/addproduct")
		public ResponseEntity<Product> addProduct(@RequestBody Product product) {		
		 Product prod = productService.saveProduct(product);		
			return new ResponseEntity<Product>(prod,HttpStatus.CREATED);
			
		}
		
		@GetMapping("/getallproducts")
		public ResponseEntity<List<Product>> getAllProducts(){
			List<Product> allProduct = productService.getAllProduct();
			return new ResponseEntity<List<Product>>(allProduct,HttpStatus.CREATED);
		}
		
		@GetMapping("/product/{id}")
		public ResponseEntity<Product>getProductByID(@PathVariable int id){
			return new ResponseEntity<Product>(productService.findProductByID(id),HttpStatus.CREATED);
		}
		
		@DeleteMapping("/deleteall")
		public ResponseEntity<String>deleteAllProduct(){
			productService.deleteAllProduct();
			return new ResponseEntity<String>("All Product are Removed From Stores",HttpStatus.CREATED);
		}
		
		@DeleteMapping("/product/{id}")
		public ResponseEntity<String>deleteProductByID(@PathVariable int id){
			productService.deleteProductByID(id);
			return new ResponseEntity<String>("Product is Deleted With Product ID "+id,HttpStatus.CREATED);
		}
		
		@PutMapping("/updateProduct")
		public Product updateProduct(@RequestBody Product Product )
		{
			return productService.updateProductInformation(Product);
			//return null;
		}
		
		
		@GetMapping("/productbyname/{productName}")
		public ResponseEntity<List<Product>> getAllProductByName(@PathVariable String productName){
			List<Product> allProduct = productService.findProductByProductName(productName);
			return new ResponseEntity<List<Product>>(allProduct,HttpStatus.CREATED);
		}
}
