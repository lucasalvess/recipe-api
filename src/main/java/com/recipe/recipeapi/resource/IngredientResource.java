package com.recipe.recipeapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipeapi.models.Ingredient;
import com.recipe.recipeapi.models.dto.IngredientDTO;
import com.recipe.recipeapi.resource.documentation.IngredientResourceDocumentation;
import com.recipe.recipeapi.service.IngredientService;

@RestController
@RequestMapping(value = "ingredient", produces = MediaType.APPLICATION_JSON_VALUE)
public class IngredientResource implements IngredientResourceDocumentation {
	
	@Autowired
	private IngredientService ingredientService;
		
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public IngredientDTO create(@RequestBody Ingredient ingredient) {
		return ingredientService.createIngredient(ingredient);
	}
	

}
