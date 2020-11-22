package com.meru.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meru.inventory.model.Inventory;
import com.meru.inventory.model.Product;
import com.meru.inventory.repo.InventoryRepository;
@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public Inventory createOrUpdateInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	@Override
	public Inventory getInventoryOfProducts(int productId) {
		Product p = new Product();
		p.setId(productId);
		return inventoryRepository.findByProductId(p);
		//return null;
	}
	
}
