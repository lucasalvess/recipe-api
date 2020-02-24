package com.recipe.recipeapi.resource.documentation;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.recipe.recipeapi.models.Ingredient;
import com.recipe.recipeapi.models.dto.IngredientDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = { @ApiResponse(code = 401, message = "Unauthorized"),
		@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found") })
public interface IngredientResourceDocumentation {
	
	@ApiOperation(value = "Create a new Ingredient")
	@ApiResponse(code = 200, message = "Ok", response = Ingredient.class)
	public IngredientDTO create(@RequestBody Ingredient ingredient);
	
	@ApiOperation(value = "Find ingredient by uuid")
	@ApiResponse(code = 200, message = "Ok", response = Ingredient.class)
	public IngredientDTO findByUuid(@PathVariable UUID uuid);
}
