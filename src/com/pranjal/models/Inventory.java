package com.pranjal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sanjay.models.Product;

@Entity
@Table(name = "inventory")
public class Inventory {
	@Column(name = "inventory_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventory_id;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	private int count;
	public int getInventory_id() {
		return inventory_id;
	}
	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Inventory [inventory_id=" + inventory_id + ", product=" + product + ", count=" + count + "]";
	}
	
	
}
