package com.sanjay.dao;

import java.util.List;

import com.sanjay.models.Product;

public interface ProductDao {

	List<Product> fetchAllProducts();

	void addProduct(Product product);

	void updateProduct(Product product);

	List<Product> fetchAllProductsForSupplier(int userid);

	void deleteProduct(int id);

	Product getProductByID(int id);

}
