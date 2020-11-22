package com.meru.inventory.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.meru.inventory.model.Product;

import com.meru.inventory.model.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	
	  Inventory findByProductId (Product productId);
	
	// @Query("FROM Inventory L WHERE L.productId = :productId")
	 //Inventory findbyProductId(@Param("productId") int productId);   


}
