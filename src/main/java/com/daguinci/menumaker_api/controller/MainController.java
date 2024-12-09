package com.daguinci.menumaker_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daguinci.menumaker_api.model.Ingredient;
import com.daguinci.menumaker_api.repository.IngredientRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller // This means that this class is a Controller
@RequestMapping(path="/ingredients") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private IngredientRepository ingredientRepository;

    @Operation(summary = "Add a new ingredient")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Ingredient created successfully"),
        @ApiResponse(responseCode = "409", description = "Ingredient already exists")
    })
    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<String> addIngredient(
        @RequestParam String name,
        @RequestParam String type,
        @RequestParam Boolean seasonal,
        @RequestParam Integer[] seasons) {

    if (ingredientRepository.existsByName(name)) {
        return new ResponseEntity<>("Ingredient already exists", HttpStatus.CONFLICT);
    }

    Ingredient n = new Ingredient();
    n.setName(name);
    n.setType(type);
    n.setSeasonal(seasonal);
    n.setSeasons(seasons);
    ingredientRepository.save(n);

    return new ResponseEntity<>("Ingredient created successfully", HttpStatus.CREATED);
}

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Ingredient> getAllIngredients() {
        // This returns a JSON or XML with the users
        return ingredientRepository.findAll();
    }

}