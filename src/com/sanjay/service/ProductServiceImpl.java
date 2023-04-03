package com.sanjay.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjay.dao.ProductDao;
import com.sanjay.models.Product;
import com.tushar.dao.OrdersDao;
import com.tushar.models.Orders;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao dao;

	@Override
	public List<Product> fetchAllProducts() {
		// TODO Auto-generated method stub
		return dao.fetchAllProducts();
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		dao.addProduct(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		dao.updateProduct(product);
	}

	@Override
	public List<Product> fetchAllProductsForSupplier(int userid) {
		// TODO Auto-generated method stub
		return dao.fetchAllProductsForSupplier(userid);
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		dao.deleteProduct(id);
		
	}

	@Override
	public Product getProductByID(int id) {
		// TODO Auto-generated method stub
		return dao.getProductByID(id);
	}
}
