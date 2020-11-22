package com.meru.composite.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.meru.composite.models.Inventory;
import com.meru.composite.models.Product;

@FeignClient(name = "inventory-service")
public interface InventoryServiceProxy {

	@GetMapping("/hello")
	public String hello();
	
	@PostMapping("/inventory")
	public int createOrUpdateInventory(@RequestBody Inventory inventory);
	
	@GetMapping("/productinventory/{productId}")
	public Inventory findInventoryOfProduct(@PathVariable int productId);
}
