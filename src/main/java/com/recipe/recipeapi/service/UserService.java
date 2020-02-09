package com.recipe.recipeapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.recipeapi.models.User;
import com.recipe.recipeapi.repository.UserRepository;

@Service
public class UserService {
	
	private static final String UUID_NOT_FOUND = "UUID not found!";

	@Autowired
	private UserRepository userRepository;

	public User findByUuid(String uuid) {
		Optional<User> user = userRepository.findByUuid(UUID.fromString(uuid));
		return user.orElseThrow(() -> new EntityNotFoundException(UUID_NOT_FOUND));
	}
	
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

	public void deleteUser(String uuid) throws Exception {
		Optional<User> user  = userRepository.findByUuid(UUID.fromString(uuid)); 
		
		if (!user.isPresent())
			throw new Exception(UUID_NOT_FOUND);

		user.get().setDeleted(Boolean.TRUE);
		userRepository.save(user.get());
	}
}
