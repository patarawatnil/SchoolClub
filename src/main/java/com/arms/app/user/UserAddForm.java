package com.arms.app.user;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserAddForm {
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
