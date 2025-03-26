package com.mylearning.coffeemachine.service;

import com.mylearning.coffeemachine.model.Drink;
import com.mylearning.coffeemachine.model.IngredientStock;
import com.mylearning.coffeemachine.model.Order;
import com.mylearning.coffeemachine.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Service
//@AllArgsConstructor
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    private DrinkService drinkService;
    private IngredientStockService ingredientStockService;
    private OrderService orderService;

    private static final LocalTime START_TIME = LocalTime.of(8, 0);
    private static final LocalTime END_TIME = LocalTime.of(17, 0);

    @Autowired
    public CoffeeMachineServiceImpl(DrinkService drinkService, IngredientStockService ingredientStockService, OrderService orderService) {
        this.drinkService = drinkService;
        this.ingredientStockService = ingredientStockService;
        this.orderService = orderService;
    }

    @Override
    public String makeDrink(String drinkName) {
        // Check for public holidays
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isBefore(START_TIME) || currentTime.isAfter(END_TIME)) {
            throw new IllegalStateException("Machine is not operating outside working hours.");
        }
//        if (isPublicHoliday()) {
//            throw new IllegalStateException("Machine is not operating on public holidays.");
//        }

        // get the drink from db
        Drink theDrink = drinkService.findDrinkByName(drinkName);

        // check ingredient stock
        List<String> ingredientNames = ingredientStockService.getAllIngredientNames();

        // Required quantities for the drink
        int[] required = {theDrink.getWater(), theDrink.getMilk(), theDrink.getCoffee()};

        for (int i = 0; i < required.length; i++) {
            String iName = ingredientNames.get(i);
            if (iName.equalsIgnoreCase("water")) {
                if (ingredientStockService.getIngredientByName(iName).getQuantity() < theDrink.getWater()) {
                    throw new IllegalArgumentException("Not enough " + iName + " in stock.");
                }
            } else if (iName.equalsIgnoreCase("milk")) {
                if (ingredientStockService.getIngredientByName(iName).getQuantity() < theDrink.getMilk()) {
                    throw new IllegalArgumentException("Not enough " + iName + " in stock.");
                }
            } else if (iName.equalsIgnoreCase("coffee")) {
                if (ingredientStockService.getIngredientByName(iName).getQuantity() < theDrink.getCoffee()) {
                    throw new IllegalArgumentException("Not enough " + iName + " in stock.");
                }
            }
        }

        // deduct ingredient stock

        // save order
        orderService.updateStats(theDrink);
        return orderService.saveOrder(theDrink).toString();
    }

}
