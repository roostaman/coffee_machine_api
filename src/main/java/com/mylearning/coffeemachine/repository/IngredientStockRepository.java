package com.mylearning.coffeemachine.repository;

import com.mylearning.coffeemachine.model.IngredientStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientStockRepository extends JpaRepository<IngredientStock, Long> {

    IngredientStock findByName(String name);
}
