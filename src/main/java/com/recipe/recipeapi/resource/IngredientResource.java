package com.recipe.recipeapi.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
	@PostMapping
	public IngredientDTO create(@RequestBody Ingredient ingredient) {
		return ingredientService.createIngredient(ingredient);
	}
	
	@GetMapping(path = "/{uuid}")
	public IngredientDTO findByUuid(@PathVariable UUID uuid) {
		return ingredientService.findIngredientByUuid(uuid);
	}
	
	@GetMapping
	public List<IngredientDTO> list(){
		return ingredientService.listAllIngredients();
	}

}
