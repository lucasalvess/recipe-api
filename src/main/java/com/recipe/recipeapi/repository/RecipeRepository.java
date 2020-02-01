package com.recipe.recipeapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipe.recipeapi.models.Recipe;
import com.recipe.recipeapi.models.User;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
	@Query("SELECT r.id, r.name, r.category, r.description FROM Recipe as r WHERE r.chef.id = ?1")
	public List<Recipe> findByUser(Long id);
}
