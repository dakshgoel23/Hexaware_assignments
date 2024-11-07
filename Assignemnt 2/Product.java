package com.hibernate.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity // THIS WILL CREATE TABLE IN DATABASE WITH NAME AS PRODUCT
public class Product {
	@Id // THIS WILL CREATE PRIMARY KEY ID IN TABLE
	@GeneratedValue(strategy = GenerationType.AUTO) // THIS MADES ID AUTOINCREMENT
	private int id;
	
	@Column(nullable =  false)
	private String title;
	
	@Column(length=1000,nullable = false)
	private String description;
	
	@Column(nullable = false)
	private double price;
	
	private LocalDate postedOn=LocalDate.now();
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Vendor vendor;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(LocalDate postedOn) {
		this.postedOn = postedOn;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", postedOn=" + postedOn + ", category=" + category + ", vendor=" + vendor + ", getCategory()="
				+ getCategory() + ", getVendor()=" + getVendor() + ", getId()=" + getId() + ", getTitle()=" + getTitle()
				+ ", getDescription()=" + getDescription() + ", getPrice()=" + getPrice() + ", getPostedOn()="
				+ getPostedOn() + "]";
	}


//	@Override
//	public String toString() {
//		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
//				+ ", postedOn=" + postedOn + ", getId()=" + getId() + ", getTitle()=" + getTitle()
//				+ ", getDescription()=" + getDescription() + ", getPrice()=" + getPrice() + ", getPostedOn()="
//				+ getPostedOn() + "]";
//	}
//	
	
	
	
	
	

}
