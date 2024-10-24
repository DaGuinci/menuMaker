package com.daguinci.menumaker_api.repository;

import org.springframework.data.repository.CrudRepository;

import com.daguinci.menumaker_api.model.Ingredient;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    boolean existsByName(String name);
}