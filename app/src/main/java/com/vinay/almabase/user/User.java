package com.vinay.almabase.user;

import java.util.Map;

/**
 * Created by Vinay Nikhil Pabba on 17-01-2016. POJO for retrieving all the User related information from Firebase
 */
public class User {
	private int id;
	private String name;
	private String username;
	private String email;
	private Map<String, Object> address;
	private String phone;
	private String website;
	private Map<String, Object> company;

	public User() {
	}

	public User(int id, String name, String username, String email, Map<String, Object> address, String phone, String website, Map<String, Object> company) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.website = website;
		this.company = company;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, Object> getAddress() {
		return address;
	}

	public void setAddress(Map<String, Object> address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Map<String, Object> getCompany() {
		return company;
	}

	public void setCompany(Map<String, Object> company) {
		this.company = company;
	}
}
