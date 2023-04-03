package com.sanjay.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.sanjay.models.Product;
import com.sanjay.models.Supplier;
import com.tushar.models.Orders;

@Service
public class ProductDaoImpl implements ProductDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Product> fetchAllProducts() {
		Query q=em.createNativeQuery("select * from product", Product.class);
		List<Product> list=q.getResultList();
		System.out.println(list);
//		Supplier k= em.find(Supplier.class,1);
////		List<Supplier>  k=(List<Supplier>) em.find(Supplier.class,1);
//		System.out.println("hhhhhhhhhhhhhhhhhh");
//		System.out.println(k);
//		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkk");
	
		return list ;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		em.persist(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		em.merge(product);
		
	}

	@Override
	public List<Product> fetchAllProductsForSupplier(int userid) {
		/*
		 * Product p= new Product(); p.setProduct_id(13); em.remove();
		 */
//		Product p=em.find(Product.class, 13);
//		em.remove(p);
		Query q=em.createNativeQuery("select * from product where supplier_id='"+userid+"'", Product.class);
		List<Product> list=q.getResultList();
		System.out.println(list);
		return list;
	}

	@Override
	public void deleteProduct(int id) {
		Product p = em.find(Product.class, id);
				em.remove(p);
		
	}

	@Override
	public Product getProductByID(int id) {
		// TODO Auto-generated method stub
		Product p = em.find(Product.class, id);
		return p;
	}

}
