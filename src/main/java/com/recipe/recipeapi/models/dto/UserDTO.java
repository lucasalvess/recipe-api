package com.recipe.recipeapi.models.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.recipe.recipeapi.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 9035680108624403643L;
	
	private UUID id;
	
	private String name;
	
	private String login;
	
	private String password;
	
	public UserDTO (User user) {
		this.id = user.getUuid();
		this.name = user.getName();
		this.login = user.getLogin();
		this.password = user.getPassword();
	}

	public UserDTO converter(User user) {
		this.id = user.getUuid();
		this.name = user.getName();
		this.login = user.getLogin();
		this.password = user.getPassword();
		return this;
	}
	
	public List<UserDTO> convertAList(List<User> userList){
		List<UserDTO> listDTO = new ArrayList<UserDTO>();

		userList.forEach(u -> listDTO.add(new UserDTO(u)));
		return listDTO;
	}
}
