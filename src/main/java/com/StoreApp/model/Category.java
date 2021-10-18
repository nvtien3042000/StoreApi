package com.StoreApp.model;

import java.util.List;

public class Category {
	
	private Integer id;
	private String name;
	private List<String> descriptions;
	
	public Category() {
		
	}
	
	public Category(Integer id, String name, List<String> description) {
		this.id = id;
		this.name = name;
		this.descriptions = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<String> description) {
		this.descriptions = description;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", descriptions=" + descriptions + "]";
	}

}
