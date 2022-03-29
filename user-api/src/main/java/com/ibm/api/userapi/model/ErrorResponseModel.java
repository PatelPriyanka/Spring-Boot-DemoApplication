package com.ibm.api.userapi.model;

public class ErrorResponseModel {
	
	private String errorMessage;
	
	public ErrorResponseModel() {
		super();
	}

	public ErrorResponseModel(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String geterrorMessage() {
		return errorMessage;
	}

	public void seterrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorResponse [errorMessage=" + errorMessage + "]";
	}

}
