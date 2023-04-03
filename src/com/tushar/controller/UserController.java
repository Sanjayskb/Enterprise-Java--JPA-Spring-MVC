package com.tushar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pranjal.models.Inventory;
import com.pranjal.service.InventoryService;
import com.sanjay.models.Product;
import com.sanjay.models.Supplier;
import com.sanjay.service.ProductService;
import com.tushar.models.Users;
import com.tushar.service.OrdersService;
import com.tushar.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userservice;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	InventoryService InventoryService;
	
	@RequestMapping(value = "/loginpage")
	public String loginPage(Model m) {
		Users user=new Users();
		m.addAttribute("user", user);
		return "loginpage";
	}
//loginuser
	@RequestMapping(value = "/loginuser")
	public String loginUser(@ModelAttribute("user") Users user,@RequestParam(value="usertype" ) String type,Model m,HttpServletRequest request) {
		System.out.println(user);
		System.out.println(type);
		int userid=userservice.getUserFromDB(user);
		if (userid == 0) {
			m.addAttribute("errormsg", "Invalid Login details");
			return "errorpage";
		}
		System.out.println("userid"+userid);
		m.addAttribute("userid", userid);
		HttpSession session= request.getSession();
		session.setAttribute("userID", userid);
		session.setAttribute("userType", type);
		if(type.equals("supplier")) {
			List<Product> list = productService.fetchAllProductsForSupplier(userid);
			Product p=new Product();
			Supplier s= new Supplier();
			s.setSupplier_id(userid);
			p.setSupplier(s);
			m.addAttribute("product", p);
			m.addAttribute("list", list);
			return "productList";
		}else {
			List<Inventory> list = InventoryService.fetchAllInventory();
			System.out.println(list);
			Inventory i=new Inventory();
			m.addAttribute("inventory", i);
			m.addAttribute("list", list);
			return "inventoryUserList";
		}
	}
}
