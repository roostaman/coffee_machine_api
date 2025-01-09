package com.mylearning.coffeemachine.service;

import com.mylearning.coffeemachine.model.IngredientStock;

import java.util.List;
import java.util.Optional;

public interface IngredientStockService {

    IngredientStock updateStock(IngredientStock ingredientStock);

    IngredientStock getIngredientByName(String name);

    Optional<IngredientStock> getIngredientById(int id);

    List<String> getAllIngredientNames();
}
