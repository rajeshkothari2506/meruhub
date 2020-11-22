package com.meru.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meru.inventory.model.Inventory;
import com.meru.inventory.model.Product;
import com.meru.inventory.service.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Inventory";
	}
	@PostMapping("/inventory")
	public int createOrUpdateInventory(@RequestBody Inventory inventory) {
		Inventory invent = inventoryService.createOrUpdateInventory(inventory);
	    return invent.getId();
	}
	
	@GetMapping("/productinventory/{productId}")
	public Inventory findInventoryOfProduct(@PathVariable int productId) {
		return inventoryService.getInventoryOfProducts(productId);
	}
}
