package com.mylearning.coffeemachine.service;

import com.mylearning.coffeemachine.model.Drink;
import com.mylearning.coffeemachine.model.DrinkStat;
import com.mylearning.coffeemachine.model.Order;

public interface OrderService {

    Order saveOrder(Drink theDrink);

    void updateStats(Drink theDrink);

    DrinkStat getMostPopularDrink();

}
