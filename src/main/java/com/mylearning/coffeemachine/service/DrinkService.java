package com.mylearning.coffeemachine.service;

import com.mylearning.coffeemachine.model.Drink;

import java.util.List;

public interface DrinkService {

    Drink addNewDrink(Drink theDrink);

    List<Drink> findAllDrinks();

    Drink findDrinkByName(String name);

}
