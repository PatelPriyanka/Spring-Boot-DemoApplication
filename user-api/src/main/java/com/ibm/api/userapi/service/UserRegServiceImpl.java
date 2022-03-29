package com.ibm.api.userapi.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.api.userapi.component.GeolocationEndpointImpl;
import com.ibm.api.userapi.constant.ConstantClass;
import com.ibm.api.userapi.controller.UserRegistrationController;
import com.ibm.api.userapi.exception.UserRegisterException;
import com.ibm.api.userapi.model.GeolocationAPIModel;
import com.ibm.api.userapi.model.UserModel;
import com.ibm.api.userapi.model.UserResponseModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserRegServiceImpl implements UserRegService {

	@Autowired
	GeolocationEndpointImpl geolocationService;
	
	private final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);
	
	public UserResponseModel registerUser(UserModel userDetails) {
		GeolocationAPIModel geolocationObj = geolocationService.getGeolocationData(userDetails.getIpAddress());
		
		logger.info("Received response from geolocationAPI for IP= " + userDetails.getIpAddress() + 
				"User country=  "+ geolocationObj.getCountry());
		
		if (!geolocationObj.getCountry().equals(ConstantClass.CANADA_COUNTRY)) {
			logger.info(ConstantClass.OUTSIDE_CANADA_ERR_MESSAG);
			throw new UserRegisterException(ConstantClass.OUTSIDE_CANADA_ERR_MESSAG);
		}
		return new UserResponseModel(UUID.randomUUID(),
				ConstantClass.USER_GREET + userDetails.getUsername() + 
				ConstantClass.USER_CITY + geolocationObj.getCity());
	
	}
}
