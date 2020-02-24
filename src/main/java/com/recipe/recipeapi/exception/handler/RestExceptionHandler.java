package com.recipe.recipeapi.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.recipe.recipeapi.exception.ExceptionDetails;
import com.recipe.recipeapi.exception.InvalidParametersException;
import com.recipe.recipeapi.exception.NotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> handleNotFound(NotFoundException resourceNotFound){
		ExceptionDetails details = ExceptionDetails.builder()
		.title("Not found")
		.status(HttpStatus.NOT_FOUND.value())
		.timestamp(new Date().getTime())
		.message(resourceNotFound.getMessage())
		.detail(resourceNotFound.getClass().getName())
		.build();
		
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidParametersException.class)
	public ResponseEntity<?> handleInvalidParameters(InvalidParametersException invalidParameters){
		ExceptionDetails details = ExceptionDetails.builder()
				.title("Invalid Parameters")
				.status(HttpStatus.UNPROCESSABLE_ENTITY.value())
				.timestamp(new Date().getTime())
				.message(invalidParameters.getMessage())
				.detail(invalidParameters.getClass().getName())
				.build();
		
		return new ResponseEntity<>(details,HttpStatus.UNPROCESSABLE_ENTITY);
	}

}
