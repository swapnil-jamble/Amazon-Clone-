package com.nil;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	private String phoneEmail;
	private String name;
	private String password;
	
	public String getPhoneEmail() {
		return phoneEmail;
	}
	public void setPhoneEmail(String phoneEmail) {
		this.phoneEmail = phoneEmail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
