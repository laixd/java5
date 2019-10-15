package com.lai.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class UsersModel {
	@Id
	@NotEmpty(message = "Không được để trống Username")
	private String username;
	
	@Size(min = 4, message = "Độ dài password ít nhất 6 kí tự")
	private String  password;
	
	@NotEmpty(message = "Không được để trống fullname")
	private String fullname;
	public UsersModel() {

	}
	public UsersModel(String username, String password, String fullname) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	
}
