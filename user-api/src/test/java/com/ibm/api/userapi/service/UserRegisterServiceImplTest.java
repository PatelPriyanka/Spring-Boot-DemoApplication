package com.ibm.api.userapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ibm.api.userapi.component.GeolocationEndpoint;
import com.ibm.api.userapi.component.GeolocationEndpointImpl;
import com.ibm.api.userapi.constant.ConstantClass;
import com.ibm.api.userapi.exception.UserRegisterException;
import com.ibm.api.userapi.model.GeolocationAPIModel;
import com.ibm.api.userapi.model.UserModel;
import com.ibm.api.userapi.model.UserResponseModel;

public class UserRegisterServiceImplTest {

	@Mock
	GeolocationEndpoint geolocationEndpointObj;
	@InjectMocks
	UserRegServiceImpl userRegService;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	@DisplayName("TestCase: #1 Should return message with username and city when all inputs valid and ip is from Canada")
	@Test
	void testRegisterUserForAllValidInputs() {

		UserModel userInput = new UserModel("Jennifer", "Jennifer$2Password", "174.93.77.54");
		GeolocationAPIModel responseserviceObj = new GeolocationAPIModel("174.93.77.54", "success",
				"Canada", "CA", "CA", "Ontario", "Toronto","M5T1A5");
		String ipAddress = userInput.getIpAddress();
		when(geolocationEndpointObj.getGeolocationData(ipAddress))
			.thenReturn(responseserviceObj);
		UserResponseModel response = userRegService.registerUser(userInput);
		
		assertEquals(response.getWelcomeMessage(), ConstantClass.USER_GREET + userInput.getUsername()
				+ ConstantClass.USER_CITY + responseserviceObj.getCity());
		verify(geolocationEndpointObj, times(1)).getGeolocationData(ipAddress);
	}
	
	@DisplayName("TestCase: #2 Should return error message for IP outside Canada")
	@Test
	void testRegisterUserForOutsideCanadaIpAddress() {
		UserModel userInput = new UserModel("AniLu", "AniLuPassword9$", "74.93.77.54");
		GeolocationAPIModel responseserviceObj = new GeolocationAPIModel("74.93.77.54", "success",
				"United States of America", "USA", "Ohio", "OH", "Cincinnati","56342");
		String ipAddress = userInput.getIpAddress();
		when(geolocationEndpointObj.getGeolocationData(ipAddress)).thenReturn(responseserviceObj);
		UserRegisterException userRegisterException = assertThrows(UserRegisterException.class, () -> {
			userRegService.registerUser(userInput);
		});
		
		String expectedMessage = ConstantClass.OUTSIDE_CANADA_ERR_MESSAG;
		String actualMessage = userRegisterException.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
		verify(geolocationEndpointObj, times(1)).getGeolocationData(ipAddress);
	}

}
