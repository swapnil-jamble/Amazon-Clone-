package com.nil;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Career {
    @Id
	private String email;
	private String position;
	private String skills;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	
}
