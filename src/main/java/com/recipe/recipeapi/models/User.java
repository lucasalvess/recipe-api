package com.recipe.recipeapi.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name="TB_USER")
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted = 0")
public class User extends AbstractModel implements Serializable{
	
	private static final long serialVersionUID = -7169638148702718527L;
	
	@Builder.Default
	@EqualsAndHashCode.Include
	@Type(type = "uuid-char")
	@Column(nullable = false)
	private UUID uuid = UUID.randomUUID();

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String login;
	
	@Column(nullable = false)
	private String password;
}
