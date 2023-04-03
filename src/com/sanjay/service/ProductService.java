package com.sanjay.service;

import java.util.List;

import com.sanjay.models.Product;

public interface ProductService {

	List<Product> fetchAllProducts();

	void addProduct(Product product);

	void updateProduct(Product product);

	List<Product> fetchAllProductsForSupplier(int userid);

	void deleteProduct(int id);

	Product getProductByID(int id);

}
