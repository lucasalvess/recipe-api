package com.recipe.recipeapi.resource.documentation;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.recipe.recipeapi.models.User;
import com.recipe.recipeapi.models.dto.UserDTO;
import com.recipe.recipeapi.models.form.UserForm;
import com.recipe.recipeapi.models.form.UserFormPut;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = { @ApiResponse(code = 401, message = "Unauthorized"),
		@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found") })
public interface UserResourceDocumentation {
	
	@ApiOperation(value = "Sign in with you login and password")
	@ApiResponse(code = 200, message = "Ok", response = User.class)
	public UserDTO login(@PathVariable String login,@PathVariable String password);
	
	@ApiOperation(value = "List all users")
	@ApiResponse(code = 200, message = "Ok", response = User.class)
	public List<UserDTO> list();
	
	@ApiOperation(value = "Create a new user")
	@ApiResponse(code = 201, message = "Ok", response = User.class)
	public UserDTO save(@RequestBody UserForm user);
	
	@ApiOperation(value = "Update an user")
	@ApiResponse(code = 200, message = "Ok", response = User.class)
	public UserDTO update(@RequestBody UserFormPut user);
	
	@ApiOperation(value = "Logical exclusion of an User")
	@ApiResponse(code = 204, message = "Deleted")
	public void delete(@PathVariable String uuid) throws Exception;
	
	@ApiOperation(value = "Do you get an user by Uuid code")
	@ApiResponse(code = 200, message = "Ok", response = User.class)
	public UserDTO findByUuid(@PathVariable String uuid);
}
