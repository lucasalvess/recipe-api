package com.recipe.recipeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.recipeapi.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByLoginAndPassword(String login, String password);
}
