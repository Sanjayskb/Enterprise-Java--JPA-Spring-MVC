package com.tushar.dao;

import java.util.List;

import com.tushar.models.Orders;

public interface OrdersDao {

	List<Orders> fetchAllOrders();

	void saveOrders(Orders orders);

}
