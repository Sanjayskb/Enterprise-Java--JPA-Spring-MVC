package com.pranjal.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pranjal.models.Inventory;
import com.sanjay.models.Product;

@Transactional
@Service
public class InventoryServiceImpl implements  InventoryService{

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
//		em.merge(inventory);
//		Product p = em.find(Product.class, inventory.getProduct().getProduct_id());
//		int count = inventory.getCount();
//		Inventory i=new Inventory();
//		i.setProduct(p);
//		i.setCount(count);
	Product p = em.find(Product.class, inventory.getProduct().getProduct_id());
    inventory.setProduct(p);
	em.persist(inventory);
		
	}

	

}
