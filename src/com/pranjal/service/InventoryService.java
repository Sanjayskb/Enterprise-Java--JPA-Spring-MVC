package com.pranjal.service;

import java.util.List;

import com.pranjal.models.Inventory;

public interface InventoryService {
	List<Inventory> fetchAllInventory();
	
	void addInventory(Inventory inventory);

	void updateInventory(Inventory inventory);

}