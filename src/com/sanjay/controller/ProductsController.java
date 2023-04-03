package com.sanjay.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanjay.models.Product;
import com.sanjay.models.Supplier;
import com.sanjay.service.ProductService;


@Controller
public class ProductsController {

	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/fetchAllProducts")
	public String fetchAllOrders(Model m) {
		List<Product> list = service.fetchAllProducts();
		System.out.println(list);
		Product p=new Product();
		m.addAttribute("product", p);
		m.addAttribute("list", list);
		return "productList";
	}
	
	
	@RequestMapping(value = "/saveproduct")
	public String saveproduct(@ModelAttribute("product") Product product,Model m) {
		System.out.println(product);
		int userid=product.getSupplier().getSupplier_id();
		service.addProduct(product);
		List<Product> list = service.fetchAllProductsForSupplier(userid);
		Product p=new Product();
		Supplier s= new Supplier();
		s.setSupplier_id(userid);
		p.setSupplier(s);
		m.addAttribute("product", p);
		m.addAttribute("list", list);
		return "productList";
	}
	@RequestMapping(value = "/updateproduct")
	public String updateproduct(@ModelAttribute("product") Product product,Model m,HttpServletRequest request) {
		System.out.println(product);
		service.updateProduct(product);
		System.out.println("from session "+request.getSession().getAttribute("userID"));
		int userid=(int )request.getSession().getAttribute("userID");
		List<Product> list = service.fetchAllProductsForSupplier(userid);
		Product p=new Product();
		Supplier s= new Supplier();
		s.setSupplier_id(userid);
		p.setSupplier(s);
		m.addAttribute("product", p);
		m.addAttribute("list", list);
		return "productList";
	}
	@RequestMapping(value = "/deleteproduct/{id}")
	public String deleteproduct(@PathVariable int id,Model m,HttpServletRequest request) {
		//System.out.println(session.getAttribute("userId"));
System.out.println("from session "+request.getSession().getAttribute("userID"));
int userid=(int )request.getSession().getAttribute("userID");
service.deleteProduct(id);
List<Product> list = service.fetchAllProductsForSupplier(userid);
Product p=new Product();
Supplier s= new Supplier();
s.setSupplier_id(userid);
p.setSupplier(s);
m.addAttribute("product", p);
m.addAttribute("list", list);
return "productList";
	}
	@RequestMapping(value = "//updateproductpage/{id}")
	public String updateproductpage(@PathVariable int id,Model m) {
		Product product=service.getProductByID(id);
		m.addAttribute("product", product);

		return "productpage";
	}
}
