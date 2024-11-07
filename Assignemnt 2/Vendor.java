package com.hibernate.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vendor {
	@Id
	private int id;
	private String name;
	private String city;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", city=" + city + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getCity()=" + getCity() + "]";
	}
	
	
	

}
