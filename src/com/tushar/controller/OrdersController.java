package com.tushar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanjay.models.Product;
import com.sanjay.service.ProductService;
import com.tushar.models.Orders;
import com.tushar.models.Users;
import com.tushar.service.OrdersService;
import com.tushar.service.UserService;

@Controller
public class OrdersController {

	@Autowired
	OrdersService service;
	
	@Autowired
	UserService userService;
	

	@Autowired
	ProductService productService; 
	
	@RequestMapping(value = "/")
	public String firstpage(Model m) {
		Users user=new Users();
		m.addAttribute("user", user);
		return "loginpage";
	}

	@RequestMapping(value = "/fetchAllOrders")
	public String fetchAllOrders(Model m) {
		List<Orders> list = service.fetchAllOrders();
		System.out.println(list);
		m.addAttribute("list", list);
		return "orderList";
	}
	
	//addtoorder
	@RequestMapping(value = "/addtoorder/{id}")
	public String addtoorder(@PathVariable int id,Model m,HttpServletRequest request) {
		Product product=productService.getProductByID(id);
		Orders orders= new Orders();
		orders.setProduct(product);
//		m.addAttribute("product",product);
		m.addAttribute("orders", orders);
		System.out.println(orders);
		
		return "addorderpage";
	}
	//saveToOrders
	@RequestMapping(value = "/saveToOrders")
	public String saveToOrders(@ModelAttribute("orders") Orders orders,Model m,HttpServletRequest request) {
		int userid=(int) request.getSession().getAttribute("userID");
		Product p=productService.getProductByID(orders.getProduct().getProduct_id());
		orders.setProduct(p);
		Users u= userService.getUserByUserID(userid);
		orders.setUsers(u);
		service.saveOrders(orders);
//		Product product=productService.getProductByID(id);
//		Orders orders= new Orders();
//		orders.setProduct(product);
////		m.addAttribute("product",product);
//		m.addAttribute("orders", orders);
		
		List<Orders> list = service.fetchAllOrders();
		System.out.println(list);
		m.addAttribute("list", list);
		return "orderList";
	}
}
