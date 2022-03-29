package com.ibm.api.userapi.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ibm.api.userapi.model.ErrorResponseModel;

@ControllerAdvice
public class UserRegisterExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UserRegisterException.class)
	public ResponseEntity<Object> handleInvalidCountryException(UserRegisterException e) {
		ErrorResponseModel errorResponse = new ErrorResponseModel(e.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
	}

	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		Map<String, List<String>> errorMap = new HashMap<>();
		List<String> errorList = e.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
		errorMap.put("errors", errorList);
		return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
	}
	
	
}
