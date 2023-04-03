package com.tushar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.tushar.models.Orders;

@Service
public class OrdersDaoImpl implements OrdersDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Orders> fetchAllOrders() {
		Query q=em.createNativeQuery("select * from orders", Orders.class);
		List<Orders> list=q.getResultList();
		return list ;
	}

	@Override
	public void saveOrders(Orders orders) {
		// TODO Auto-generated method stub
		em.persist(orders);
		
	}

}
