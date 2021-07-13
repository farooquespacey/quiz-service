package com.spacey.qz.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spacey.qz.res.StatusResponse;

// to define exception handling globally
@ControllerAdvice
public class QuizExceptionHandler {

	@ExceptionHandler(IllegalNameException.class) // (optional to list exceptions here) takes an exception or a
													// list of exceptions as an argument that
													// we want to handle in the defined method
	@ResponseStatus(code = HttpStatus.BAD_REQUEST) // Also, the annotation @ResponseStatus(HttpStatus.BAD_REQUEST) on
													// the
													// handler method is not required as the HTTP status passed into the
													// ResponseEnity will take precedence, but we have kept it anyway
													// for the same readability reasons.
	public ResponseEntity<StatusResponse> handleIllegalNameException(IllegalNameException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new StatusResponse("failure", "INE: " + exception.getMessage()));
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<StatusResponse> handleEmptyResultDataAccessException(
			EmptyResultDataAccessException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new StatusResponse("failure", "ERDAE: " + exception.getMessage()));
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<StatusResponse> handleGenericException(Exception exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new StatusResponse("failure", "EXC: " + exception.getMessage()));
	}

}
