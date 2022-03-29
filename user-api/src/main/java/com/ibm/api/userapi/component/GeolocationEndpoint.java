package com.ibm.api.userapi.component;
import com.ibm.api.userapi.model.GeolocationAPIModel;

public interface GeolocationEndpoint {
	public GeolocationAPIModel getGeolocationData(String idAddress);
}
