package com.recipe.recipeapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.recipeapi.models.User;
import com.recipe.recipeapi.models.dto.UserDTO;
import com.recipe.recipeapi.repository.UserRepository;

@Service
public class UserService {
	
	private static final String UUID_NOT_FOUND = "UUID not found!";

	@Autowired
	private UserRepository userRepository;

	private static final UserDTO userDTO = new UserDTO();

	public UserDTO findByUuid(String uuid) {
		Optional<User> user = userRepository.findByUuid(UUID.fromString(uuid));
		
		if(!user.isEmpty()) {
			return userDTO.converter(user.get());
		}

		throw new EntityNotFoundException(UUID_NOT_FOUND);
	}
	
	public UserDTO updateUser(User userForm) {
		return userDTO.converter(userRepository.save(userForm));
	}

	public List<UserDTO> listUsers() {
		return userDTO.convertAList(userRepository.findAll());
	}

	public UserDTO login(String login, String password) {
		return userDTO.converter(userRepository.findByLoginAndPassword(login, password));
	}

	public UserDTO createUser(User user) {
		return userDTO.converter(userRepository.save(user));
	}

	public void deleteUser(String uuid) throws Exception {
		Optional<User> user  = userRepository.findByUuid(UUID.fromString(uuid)); 
		
		if (!user.isPresent())
			throw new Exception(UUID_NOT_FOUND);

		user.get().setDeleted(Boolean.TRUE);
		userRepository.save(user.get());
	}
}
