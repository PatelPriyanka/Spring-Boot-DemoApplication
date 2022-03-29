package com.ibm.api.userapi.model;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserModel {
	
	@NotEmpty(message = "Username is required")
	@NotNull(message = "Username is required")
	private String username;
	
	@NotEmpty(message = "Password is required")
	@NotNull(message = "Password is required")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[_#$%.]).{9,}$", message = "password must at least 9 characters and contain at least 1 number, 1 Capital letter and 1 special character from [_, #, $, %, .]")
	private String password;
	
	@NotEmpty(message = "ipAddress is required")
	@NotNull(message = "ipAddress is required")
	private String ipAddress;

	
	public UserModel() {
		super();
	}

	public UserModel(
			@NotEmpty(message = "Username is required") @NotNull(message = "Username is required") String username,
			@NotEmpty(message = "Password is required") @NotNull(message = "Password is required") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[_#$%.]).{9,}$", message = "password must at least 9 characters and contain at least 1 number, 1 Capital letter and 1 special character from [_, #, $, %, .]") String password,
			@NotEmpty(message = "ipAddress is required") @NotNull(message = "ipAddress is required") String ipAddress) {
		super();
		this.username = username;
		this.password = password;
		this.ipAddress = ipAddress;
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

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", ipAddress=" + ipAddress + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ipAddress, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		return Objects.equals(ipAddress, other.ipAddress) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
}
