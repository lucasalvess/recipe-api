package com.recipe.recipeapi.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ExceptionDetails {
	
	private String title;
	private int status;
	private String message;
	private long timestamp;
	private String detail;
}
