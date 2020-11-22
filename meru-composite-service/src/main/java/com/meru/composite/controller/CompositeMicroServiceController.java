package com.meru.composite.controller;

import java.util.ArrayList;
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

import com.meru.composite.models.Cart;
import com.meru.composite.models.CartDetails;
import com.meru.composite.models.Inventory;
import com.meru.composite.models.OrderStatus;
import com.meru.composite.models.Product;
import com.meru.composite.models.ProductDetails;
import com.meru.composite.proxy.CartServiceProxy;
import com.meru.composite.proxy.InventoryServiceProxy;
import com.meru.composite.proxy.OrderServiceProxy;
import com.meru.composite.proxy.ProductServiceProxy;

@RestController
public class CompositeMicroServiceController {

	
	
	@Autowired
	CartServiceProxy cartServiceProxy;
	
	@Autowired
	InventoryServiceProxy inventoryServiceProxy;
	
	@Autowired
	ProductServiceProxy productServiceProxy;
	
	@Autowired
	OrderServiceProxy orderServiceProxy;
	
	@GetMapping("/hello")
	public String hello() {
		return inventoryServiceProxy.hello();
	}
	
	@PostMapping("/createcart")
	public int createCart(@RequestBody Cart cart) {
		int cartId =  cartServiceProxy.createCart(cart);
		cart.setId(cartId);
		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setOrderStatus("Created");
		orderStatus.setCartId(cart);		
		orderServiceProxy.creatOrUpdateOrderDetails(orderStatus);		
		return cartId;
		
	}
	
	@PostMapping("/addtocart")
	public int addItemToCart(@RequestBody CartDetails cartDetails) {
		return cartServiceProxy.addItemToCart(cartDetails);
	}
	
	@GetMapping("/createproduct/{productName}/{price}/{availableInventory}")
	public ResponseEntity<Product> createProduuct(@PathVariable String productName, @PathVariable int price,@PathVariable int availableInventory) {
	
		Product product = new  Product ();
		product.setPrice(price);
		product.setProductName(productName);
		ResponseEntity<Product> savedProduct = productServiceProxy.addProduct(product);
		if(savedProduct !=null) {
			Inventory inventory = new Inventory();
			inventory.setProductId(savedProduct.getBody());
			inventory.setAvailableInventory(availableInventory);
			inventoryServiceProxy.createOrUpdateInventory(inventory);
		}
		
      //  return new ResponseEntity<String>("Product is Added with ID "+savedProduct.getBody().getId(),HttpStatus.CREATED);
		return new ResponseEntity<Product>(savedProduct.getBody(),HttpStatus.CREATED);
		  
	}
	
	@GetMapping("/getallproducts")
	public ResponseEntity <List<ProductDetails>> getAllProducts(){	
		List<ProductDetails> productList = new ArrayList<ProductDetails>();
		List<Product> listOfProduct =  productServiceProxy.getAllProducts().getBody();
		for(Product product : listOfProduct) {
			Inventory productInventory = inventoryServiceProxy.findInventoryOfProduct(product.getId());
			ProductDetails pd = new ProductDetails();
			pd.setId(product.getId());
			pd.setPrice(product.getPrice());
			pd.setProductName(product.getProductName());
			pd.setAvaiableQty(productInventory.getAvailableInventory());
			productList.add(pd);			
		}		
		return new ResponseEntity<List<ProductDetails>>(productList,HttpStatus.CREATED);
				
		//return null;
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDetails>getProductByID(@PathVariable int id){
		ResponseEntity<Product> savedProduct = productServiceProxy.getProductByID(id);
		Product product = savedProduct.getBody();
		Inventory productInventory = inventoryServiceProxy.findInventoryOfProduct(id);
		ProductDetails pd = new ProductDetails();
		pd.setId(product.getId());
		pd.setPrice(product.getPrice());
		pd.setProductName(product.getProductName());
		pd.setAvaiableQty(productInventory.getAvailableInventory());
		return new ResponseEntity<ProductDetails>(pd,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<String>deleteAllProduct(){
		//inventoryServiceProxy.de
		return productServiceProxy.deleteAllProduct();
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String>deleteProductByID(@PathVariable int id){
		return productServiceProxy.deleteProductByID(id);
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product Product )
	{
		return productServiceProxy.updateProduct(Product);
	}
	
	@GetMapping("/productbyname/{productName}")
	public ResponseEntity<List<Product>> getAllProductByName(@PathVariable String productName){
		return productServiceProxy.getAllProductByName(productName);	
	}
	
	@GetMapping("/productinventory/{productId}")
	public Inventory findInventoryOfProduct(@PathVariable int productId){
		return inventoryServiceProxy.findInventoryOfProduct(productId);
	}
	
	
		
}
