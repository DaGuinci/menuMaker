package com.daguinci.menumaker_api.Ingredient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController // This means that this class is a Controller
@RequestMapping("/ingredients") // This means URL's start with /ingredients (after Application path)
public class IngredientController {
    
    @Autowired
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @PostMapping(path="/add")
    public void addIngredient(@Valid @RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
    }

    @DeleteMapping(path = "{ingredientId}")
    public void deleteIngredient(
        @PathVariable("ingredientId") Long ingredientId) {
        ingredientService.deleteIngredient(ingredientId);
    }
}