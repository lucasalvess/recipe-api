package com.recipe.recipeapi.resource.documentation;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.recipe.recipeapi.models.dto.RecipeDTO;
import com.recipe.recipeapi.models.form.RecipeForm;
import com.recipe.recipeapi.models.form.RecipeFormPut;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = { @ApiResponse(code = 401, message = "Unauthorized"),
		@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found") })
public interface RecipeResourceDocumentation {

	@ApiOperation(value = "List all recipes by chef")
	@ApiResponse(code = 200, message = "Ok", response = RecipeDTO.class)
	public List<RecipeDTO> listByChef(Long id);
	
	@ApiOperation(value = "Find recipe by uuid")
	@ApiResponse(code = 200, message = "Ok", response = RecipeDTO.class)
	public RecipeDTO findByUuid(@PathVariable UUID uuid);
	
	@ApiOperation(value = "Create a new recipe")
	@ApiResponse(code = 201, message = "Ok", response = RecipeDTO.class)
	public RecipeDTO create(@RequestBody RecipeForm recipeForm);
	
	@ApiOperation(value = "Update a recipe")
	@ApiResponse(code = 200, message = "Ok", response = RecipeDTO.class)
	public RecipeDTO update(@RequestBody RecipeFormPut recipeFormPut);
	
	@ApiOperation(value = "Delete a recipe")
	@ApiResponse(code = 204, message = "Ok", response = RecipeDTO.class)
	public void delete(@PathVariable UUID uuid);

}
