package com.ibm.api.userapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.api.userapi.model.UserModel;
import com.ibm.api.userapi.model.UserResponseModel;
import com.ibm.api.userapi.service.UserRegistrationService;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {

	@Autowired
	UserRegistrationService userServiceObj;
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserModel userInput){
		
		UserResponseModel userResponse = userServiceObj.registerUser(userInput);
		ResponseEntity<UserResponseModel> userResponseObject = new ResponseEntity<UserResponseModel>(userResponse, HttpStatus.OK);
		return userResponseObject;
	}
}
