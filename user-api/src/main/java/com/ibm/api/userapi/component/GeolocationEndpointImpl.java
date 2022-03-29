package com.ibm.api.userapi.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ibm.api.userapi.model.GeolocationAPIModel;

@Component
public class GeolocationEndpointImpl implements GeolocationEndpoint {

	private RestTemplate restTemplate;
	public GeolocationEndpointImpl() {
		this.restTemplate = new RestTemplate();
	}
	
	@Value("${geolocation.API.endpointUrl}")
	String endpointUrl;
	
	@Override
	public GeolocationAPIModel getGeolocationData(String idAddress) {
		String finalUrl =  endpointUrl + "/" + idAddress;
		GeolocationAPIModel geolocationObj = this.restTemplate.getForObject(finalUrl, GeolocationAPIModel.class);
		return geolocationObj;
	}
}
