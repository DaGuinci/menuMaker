package com.daguinci.menumaker_api.Ingredient;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daguinci.menumaker_api.Ingredient.exception.IngredientNotFoundException;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredients() {
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    public void addIngredient(Ingredient ingredient) {
        Boolean existsName = ingredientRepository.existsByName(ingredient.getName());
        if (existsName) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Name " + ingredient.getName() + " taken");
        }

        ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(Long ingredientId) {
        if(!ingredientRepository.existsById(ingredientId)) {
            throw new IngredientNotFoundException(
                    "Ingredient with id " + ingredientId + " does not exists");
        }
        ingredientRepository.deleteById(ingredientId);
    }
}