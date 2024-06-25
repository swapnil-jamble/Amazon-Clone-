package com.nil;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {

	@Id
	private String email;
	private String name;
	private long phonenno;
	private String city;
	private int pincode;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhonenno() {
		return phonenno;
	}
	public void setPhonenno(long phonenno) {
		this.phonenno = phonenno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
}

