package com.ibm.api.userapi.service;

import java.util.Optional;

import com.ibm.api.userapi.model.UserModel;
import com.ibm.api.userapi.model.UserResponseModel;

public interface UserRegistrationService {
	public abstract UserResponseModel registerUser(UserModel userDetails);
}
