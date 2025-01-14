package com.daguinci.menumaker_api.Ingredient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IngredientNotFoundException extends RuntimeException{

    public IngredientNotFoundException(String msg) {
        super(msg);
    }
}