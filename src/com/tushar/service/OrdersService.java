package com.tushar.service;

import java.util.List;

import com.tushar.models.Orders;

public interface OrdersService {

	List<Orders> fetchAllOrders();

	void saveOrders(Orders orders);

}
