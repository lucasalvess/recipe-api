package com.recipe.recipeapi.exception;

public class InvalidParametersException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidParametersException(String message) {
		super(message);
	}
}
