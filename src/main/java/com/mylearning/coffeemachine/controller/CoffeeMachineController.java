package com.mylearning.coffeemachine.controller;

import com.mylearning.coffeemachine.model.Drink;
import com.mylearning.coffeemachine.model.DrinkStat;
import com.mylearning.coffeemachine.model.IngredientStock;
import com.mylearning.coffeemachine.service.CoffeeMachineService;
import com.mylearning.coffeemachine.service.DrinkService;
import com.mylearning.coffeemachine.service.IngredientStockService;
import com.mylearning.coffeemachine.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CoffeeMachineController {

    private CoffeeMachineService coffeeMachineService;
    private DrinkService drinkService;
    private OrderService orderService;
    private IngredientStockService ingredientStockService;

    @PostMapping("/drinks/{drinkName}")
    public ResponseEntity<String> prepareDrink(@PathVariable String drinkName) {
        String result = coffeeMachineService.makeDrink(drinkName);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/drinks")
    public ResponseEntity<Drink> addDrink(@Valid @RequestBody Drink theDrink) {
        Drink addedDrink = drinkService.addNewDrink(theDrink);
        return ResponseEntity.ok(addedDrink);
    }

    @PutMapping("/stock")
    public ResponseEntity<IngredientStock> updateStock(@Valid @RequestBody IngredientStock theIngredientStock) {
        IngredientStock updatedStock = ingredientStockService.updateStock(theIngredientStock);
        return ResponseEntity.ok(updatedStock);
    }

    @GetMapping("/stats/popular")
    public ResponseEntity<DrinkStat> getMostPopularDrink() {
        DrinkStat mostPopularDrink = orderService.getMostPopularDrink();
        return ResponseEntity.ok(mostPopularDrink);
    }

    @GetMapping("/drinks")
    public ResponseEntity<List<Drink>> getAllDrinks() {
        List<Drink> drinks = drinkService.findAllDrinks();
        return ResponseEntity.ok(drinks);
    }
}
