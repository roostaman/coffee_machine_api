package com.mylearning.coffeemachine.service;

import com.mylearning.coffeemachine.model.IngredientStock;
import com.mylearning.coffeemachine.repository.IngredientStockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@AllArgsConstructor
public class IngredientStockServiceImpl implements IngredientStockService {

    private IngredientStockRepository ingredientStockRepository;

    public IngredientStockServiceImpl(IngredientStockRepository ingredientStockRepository) {
        this.ingredientStockRepository = ingredientStockRepository;
    }

    @Override
    public IngredientStock updateStock(IngredientStock newIngredientStock) {
        return ingredientStockRepository.save(newIngredientStock);
    }

    @Override
    public IngredientStock getIngredientByName(String name) {
        return ingredientStockRepository.findByName(name);
    }

    @Override
    public Optional<IngredientStock> getIngredientById(int id) {
        Optional<IngredientStock> result = ingredientStockRepository.findById((long) id);

        if (result.isEmpty()) {
            throw new RuntimeException("Ingredient stock not found with id - " + id);
        }
        return result;
    }

    @Override
    public List<String> getAllIngredientNames() {
        return ingredientStockRepository.findAll().stream()
                .map(IngredientStock::getName)
                .collect(Collectors.toList());
    }

}
