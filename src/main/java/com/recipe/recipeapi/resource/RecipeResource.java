package com.recipe.recipeapi.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipeapi.models.dto.RecipeDTO;
import com.recipe.recipeapi.models.form.RecipeForm;
import com.recipe.recipeapi.models.form.RecipeFormPut;
import com.recipe.recipeapi.resource.documentation.RecipeResourceDocumentation;
import com.recipe.recipeapi.service.RecipeService;

@RestController
@RequestMapping(value = "recipe", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecipeResource implements RecipeResourceDocumentation{

	@Autowired
	private RecipeService service;
	
	@GetMapping
	public List<RecipeDTO> listByChef(Long id){
		return service.findRecipesByChef(id);
	}
	
	@GetMapping(path = "/{uuid}")
	public RecipeDTO findByUuid(@PathVariable UUID uuid) {
		return service.findRecipeByUuid(uuid);
	}
	
	@PostMapping
	public RecipeDTO create(@RequestBody RecipeForm recipeForm) {
		return service.createRecipe(recipeForm);
	}
	
	@PutMapping
	public RecipeDTO update(@RequestBody RecipeFormPut recipeFormPut) {
		return service.updateRecipe(recipeFormPut);
	}
	
	@DeleteMapping(path = "/{uuid}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID uuid) {
		service.deleteRecipeByUuid(uuid);
	}
}
