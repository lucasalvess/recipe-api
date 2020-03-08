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

import com.recipe.recipeapi.models.User;
import com.recipe.recipeapi.models.dto.UserDTO;
import com.recipe.recipeapi.models.form.UserForm;
import com.recipe.recipeapi.models.form.UserFormPut;
import com.recipe.recipeapi.resource.documentation.UserResourceDocumentation;
import com.recipe.recipeapi.service.UserService;

@RestController
@RequestMapping(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserResource implements UserResourceDocumentation {

	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/{login}/{password}")
	public UserDTO login(@PathVariable String login,@PathVariable String password) {
		return userService.login(login, password);
	}
	
	@GetMapping
	public List<UserDTO> list() {
		return userService.listUsers();
	}
	
	@GetMapping(path = "/{uuid}")
	public UserDTO findByUuid(@PathVariable String uuid){
		return userService.findByUuid(uuid);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO save(@RequestBody UserForm user){
		return userService.createUser(user.convertToEntity());
		
	}
	
	@PutMapping
	public UserDTO update(@RequestBody UserFormPut userForm) {
		return userService.updateUser(userForm.convertToEntity());
	}
	
	@DeleteMapping(path = "/{uuid}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String uuid) throws Exception {
		userService.deleteUser(uuid);
	}

}
