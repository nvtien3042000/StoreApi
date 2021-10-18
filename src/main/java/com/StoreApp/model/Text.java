package com.StoreApp.model;

public class Text {
	public static String NAME = "name";
	public static String PASS = "pass";
	public static String ROLE = "role";
	
	
	private String name;
	private String pass;
	private int role;
	
	public Text() {

	}
	
	public Text(String name, String pass, int role) {
		this.name = name;
		this.pass = pass;
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpass() {
		return pass;
	}
	public void setpass(String pass) {
		this.pass = pass;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	public int getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "Text [name=" + name + ", pass=" + pass + ", role=" + role + "]";
	}
	
}
