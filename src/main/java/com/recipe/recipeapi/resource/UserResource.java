package com.recipe.recipeapi.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipeapi.models.User;
import com.recipe.recipeapi.repository.UserRepository;
import com.recipe.recipeapi.service.UserService;

@RestController
@RequestMapping(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/{login}/{password}")
	public User login(@PathVariable String login,@PathVariable String password) {
		return userService.login(login, password);
	}
	
	@GetMapping
	public List<User> list() {
		return userService.listUsers();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public User save(@RequestBody User user){
		return userService.createUser(user);
		
	}
	
	@PatchMapping
	public User update(@RequestBody User user) {
		return userService.updateUser(user);
	}
}
