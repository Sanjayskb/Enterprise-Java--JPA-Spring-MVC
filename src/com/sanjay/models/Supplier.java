package com.sanjay.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {
	@Column(name = "supplier_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplier_id;
	private String supplier_name;
	private String supplier_detail;
	private String supplier_contact_no;
	private String supplier_email;
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_detail() {
		return supplier_detail;
	}
	public void setSupplier_detail(String supplier_detail) {
		this.supplier_detail = supplier_detail;
	}
	public String getSupplier_contact_no() {
		return supplier_contact_no;
	}
	public void setSupplier_contact_no(String supplier_contact_no) {
		this.supplier_contact_no = supplier_contact_no;
	}
	public String getSupplier_email() {
		return supplier_email;
	}
	public void setSupplier_email(String supplier_email) {
		this.supplier_email = supplier_email;
	}
	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", supplier_name=" + supplier_name + ", supplier_detail="
				+ supplier_detail + ", supplier_contact_no=" + supplier_contact_no + ", supplier_email="
				+ supplier_email + "]";
	}
	
//	@OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn
//	private List<Product> product;
	
}