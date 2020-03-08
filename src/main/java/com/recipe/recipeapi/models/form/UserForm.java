package com.recipe.recipeapi.models.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.recipe.recipeapi.models.User;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserForm implements Serializable{
		
	private static final long serialVersionUID = 9035680408624403643L;
	
	@ApiModelProperty(example = "João da Silva", value = "Nome completo do usuario")
	@NotEmpty(message = "{recipe.form.name.is.empty}")
	private String name;
	
	@ApiModelProperty(example = "UserName", value = "Unique username login")
	@NotEmpty(message = "{recipe.form.login.is.empty}")
	private String login;

	@ApiModelProperty(example = "********", value = "Password")
	@NotEmpty(message = "{recipe.form.password.is.empty}")
	private String password;
	
	public User convertToEntity() {
		return User.builder()
				.name(name)
				.login(login)
				.password(password)
				.build();
	}
		
}
