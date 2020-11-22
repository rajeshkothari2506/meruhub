package com.meru.inventory.service;


import java.util.List;

import com.meru.inventory.model.Inventory;
import com.meru.inventory.model.Product;

public interface InventoryService {

	public Inventory createOrUpdateInventory(Inventory inventory);
	
	public Inventory getInventoryOfProducts (int productId);
}
