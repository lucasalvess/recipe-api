package com.recipe.recipeapi.service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.recipeapi.exception.InvalidParametersException;
import com.recipe.recipeapi.exception.NotFoundException;
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
		Optional<User> user;
		
		try {
			user = userRepository.findByUuid(UUID.fromString(uuid));
			return new UserDTO(user.get());
		}catch (Exception e) {
			throw new NotFoundException(UUID_NOT_FOUND);
		}
	}
	
	public UserDTO updateUser(User userForm) {
		return new UserDTO(userRepository.save(userForm));
	}

	public List<UserDTO> listUsers() {
		return userDTO.convertAList(userRepository.findAll());
	}

	public UserDTO login(String login, String password) {
		try {
			return new UserDTO(userRepository.findByLoginAndPassword(login, password));
		}catch (InvalidParameterException e) {
			throw new InvalidParametersException("Invalid login and password");
		}catch (RuntimeException e) {
			throw new NotFoundException("User not found");
		}

	}

	public UserDTO createUser(User user) {
		return new UserDTO(userRepository.save(user));
	}

	public void deleteUser(String uuid) throws Exception {
		Optional<User> user  = userRepository.findByUuid(UUID.fromString(uuid)); 
		
		if (!user.isPresent())
			throw new NotFoundException(UUID_NOT_FOUND);

		user.get().setDeleted(Boolean.TRUE);
		userRepository.save(user.get());
	}
}
