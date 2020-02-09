package com.recipe.recipeapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.recipeapi.models.User;
import com.recipe.recipeapi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User updateUser(User userForm) {
		return userRepository.save(userForm);
	}

	public List<User> listUsers() {
		return userRepository.findAll();
	}

	public User login(String login, String password) {
		return userRepository.findByLoginAndPassword(login, password);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}
}
