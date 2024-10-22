package com.daguinci.menumaker_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/ingredients") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private IngredientRepository ingredientRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewIngredient (
        @RequestParam String name,
        @RequestParam String type,
        @RequestParam Boolean seasonal,
        @RequestParam Integer[] seasons
        ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Ingredient n = new Ingredient();
        n.setName(name);
        n.setType(type);
        n.setSeasonal(seasonal);
        n.setSeasons(seasons);
        ingredientRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Ingredient> getAllIngredients() {
        // This returns a JSON or XML with the users
        return ingredientRepository.findAll();
    }
}