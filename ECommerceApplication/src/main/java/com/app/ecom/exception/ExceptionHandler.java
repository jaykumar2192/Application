package com.app.ecom.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

	private HttpHeaders header = new HttpHeaders();

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<?> genericException(Exception ex) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(ex.getMessage());
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(UserException.class)
	public ResponseEntity<?> UserException(UserException ex) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(ex.getMessage());
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(ProductException.class)
	public ResponseEntity<?> ProductException(ProductException ex) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(ex.getMessage());
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(SellerException.class)
	public ResponseEntity<?> SellerException(SellerException ex) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(ex.getMessage());
	}
}
