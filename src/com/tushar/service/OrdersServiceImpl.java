package com.tushar.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tushar.dao.OrdersDao;
import com.tushar.models.Orders;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	OrdersDao dao;
	
	

	@Override
	public List<Orders> fetchAllOrders() {
		// TODO Auto-generated method stub
		return dao.fetchAllOrders();
	}

	@Override
	public void saveOrders(Orders orders) {
		// TODO Auto-generated method stub
		double totalAmount=orders.getProduct().getProduct_price()*orders.getQuantity();
		orders.setAmount(totalAmount);
		dao.saveOrders(orders);
		
		
		
	}

}
