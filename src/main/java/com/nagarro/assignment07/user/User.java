package com.nagarro.assignment07.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	private int id;
	private String Username;
	private String Password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
}
