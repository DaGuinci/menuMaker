package com.daguinci.menumaker_api;

import org.springframework.data.repository.CrudRepository;

import com.daguinci.menumaker_api.Ingredient;;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    boolean existsByName(String name);
}