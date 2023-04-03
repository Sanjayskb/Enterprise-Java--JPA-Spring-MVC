package com.pranjal.dao;

import java.util.List;

import com.pranjal.models.Inventory;


public interface InventoryDao {
	List<Inventory> fetchAllInventory();
	
	void addInventory(Inventory inventory);

	void updateInventory(Inventory inventory);

}
