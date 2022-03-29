package com.ibm.api.userapi.model;

import java.util.Objects;
import java.util.UUID;

public class UserResponseModel {
	
	private UUID id;
	private String welcomeMessage;
	
	public UserResponseModel() {
		super();
	}

	public UserResponseModel(UUID id, String welcomeMessage) {
		super();
		this.id = id;
		this.welcomeMessage = welcomeMessage;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	@Override
	public String toString() {
		return "UserRegResponse [id=" + id + ", welcomeMessage=" + welcomeMessage + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, welcomeMessage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserResponseModel other = (UserResponseModel) obj;
		return Objects.equals(id, other.id) && Objects.equals(welcomeMessage, other.welcomeMessage);
	}

}
