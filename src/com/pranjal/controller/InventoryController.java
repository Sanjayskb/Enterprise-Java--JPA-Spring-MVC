package com.pranjal.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pranjal.models.Inventory;
import com.pranjal.service.InventoryService;
import com.sanjay.models.Product;
import com.sanjay.service.ProductService;





@Controller
public class InventoryController {
	@Autowired
	InventoryService service;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/fetchAllInventory")
	public String fetchAllInventory(Model m) {
		List<Inventory> list = service.fetchAllInventory();
		System.out.println(list);
		Inventory i=new Inventory();
		m.addAttribute("inventory", i);
		m.addAttribute("list", list);
		return "inventoryList";
		
	}
		@RequestMapping(value = "/saveInventory")
		public String saveinventory(@ModelAttribute("inventory") Inventory inventory,Model m) {
			System.out.println(inventory);
			service.addInventory(inventory);
			List<Inventory> list = service.fetchAllInventory();
			System.out.println(list);
			Inventory i=new Inventory();
			m.addAttribute("inventory", i);
			m.addAttribute("list", list);
			return "inventoryList";
		}
		@RequestMapping(value = "/addToInventory")
		public String updateInventory(@ModelAttribute("inventory") Inventory inventory,Model m) {
			System.out.println(inventory);
			service.updateInventory(inventory);
			List<Inventory> list = service.fetchAllInventory();
			System.out.println(list);
			Inventory i=new Inventory();
			m.addAttribute("inventory", i);
			m.addAttribute("list", list);
			return "inventoryList";
		}
		
		@RequestMapping(value = "/updateproductinventorypage/{id}")
		public String updateproductpage(@PathVariable int id,Model m) {
			Product product=productService.getProductByID(id);
			m.addAttribute("product", product);
			Inventory inventory= new Inventory();
			inventory.setProduct(product);
			m.addAttribute("inventory",inventory);
			
			

			return "addCount";
		}
		
		//addToInventory
	}


