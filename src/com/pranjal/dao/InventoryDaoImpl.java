package com.pranjal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.pranjal.models.Inventory;
import com.sanjay.models.Product;

@Service
public class InventoryDaoImpl implements  InventoryDao{

	@PersistenceContext
	EntityManager em;
	@Override
	public List<Inventory> fetchAllInventory() {
		Query q=em.createNativeQuery("select * from inventory", Inventory.class);
		List<Inventory> list=q.getResultList();
		return list ;
	}

	@Override
	public void addInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		em.persist(inventory);
	}

	@Override
	public void updateInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		em.merge(inventory);
	}

	

}
