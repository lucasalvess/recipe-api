package com.recipe.recipeapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipeapi.models.User;
import com.recipe.recipeapi.repository.UserRepository;

@RestController
@RequestMapping(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	
	public User login(@RequestAttribute String login,@RequestAttribute String password) {
		return userRepository.findByLoginAndPassword(login, password);
	}
}
