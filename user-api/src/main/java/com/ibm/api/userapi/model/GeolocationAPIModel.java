package com.ibm.api.userapi.model;


public class GeolocationAPIModel {

	private String query;
	private String status;
	private String country;
	private String countryCode;
	private String region;
	private String regionName;
	private String city;
	private String zip;
	
	public GeolocationAPIModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeolocationAPIModel(String query, String status, String country, String countryCode, String region,
			String regionName, String city, String zip) {
		super();
		this.query = query;
		this.status = status;
		this.country = country;
		this.countryCode = countryCode;
		this.region = region;
		this.regionName = regionName;
		this.city = city;
		this.zip = zip;
	}
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "GeoLocationResponse [query=" + query + ", status=" + status + ", country=" + country + ", countryCode="
				+ countryCode + ", region=" + region + ", regionName=" + regionName + ", city=" + city + ", zip=" + zip
				+ "]";
	}
	
	
	
	
}
