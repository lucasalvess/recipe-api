package com.recipe.recipeapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipeapi.models.Recipe;
import com.recipe.recipeapi.resource.documentation.RecipeResourceDocumentation;
import com.recipe.recipeapi.service.RecipeService;

@RestController
@RequestMapping(value = "recipe", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecipeResource implements RecipeResourceDocumentation{

	@Autowired
	private RecipeService service;
	
	@GetMapping
	public List<Recipe> list(){
		return service.findAllRecipes();
	}
}
