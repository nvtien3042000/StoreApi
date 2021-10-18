package com.StoreApp.model;

import java.util.List;

public class Product {
	
	private Integer id;
	private String name;
	private String description;
	private Double price;
	private List<String> images;
	
	public Product() {
		
	}
	public Product(Integer id, String name, String description, Double price, List<String> images) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.images = images;
	}
	public Integer getid() {
		return id;
	}
	public void setid(Integer id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", images=" + images + "]";
	}
	
	
}
