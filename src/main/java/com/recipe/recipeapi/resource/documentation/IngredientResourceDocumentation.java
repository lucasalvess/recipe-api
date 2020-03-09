package com.recipe.recipeapi.resource.documentation;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.recipe.recipeapi.models.Ingredient;
import com.recipe.recipeapi.models.dto.IngredientDTO;
import com.recipe.recipeapi.models.form.IngredientForm;
import com.recipe.recipeapi.models.form.IngredientFormPut;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = { @ApiResponse(code = 401, message = "Unauthorized"),
		@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found") })
public interface IngredientResourceDocumentation {
	
	@ApiOperation(value = "Create a new Ingredient")
	@ApiResponse(code = 201, message = "Ok", response = Ingredient.class)
	public IngredientDTO create(@RequestBody IngredientForm ingredient);
	
	@ApiOperation(value = "Find ingredient by uuid")
	@ApiResponse(code = 200, message = "Ok", response = Ingredient.class)
	public IngredientDTO findByUuid(@PathVariable UUID uuid);
	
	@ApiOperation(value = "List all ingredients")
	@ApiResponse(code = 200, message = "Ok", response = Ingredient.class)
	public List<IngredientDTO> list();
	
	@ApiOperation(value = "Delete an ingredient by uuid")
	@ApiResponse(code = 204, message = "Ok", response = Ingredient.class)
	public void delete(@PathVariable UUID uuid, HttpServletResponse response);
	
	@ApiOperation(value = "Update an ingredient")
	@ApiResponse(code = 204, message = "Ok", response = Ingredient.class)
	public IngredientDTO update(@RequestBody IngredientFormPut ingredient);
}
