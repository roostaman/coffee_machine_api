package com.mylearning.coffeemachine.service;

import com.mylearning.coffeemachine.model.Drink;
import com.mylearning.coffeemachine.model.Order;
import com.mylearning.coffeemachine.repository.DrinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
//@AllArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private DrinkRepository drinkRepository;

    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public Drink addNewDrink(Drink theDrink) {

        return drinkRepository.save(theDrink);
    }

    @Override
    public List<Drink> findAllDrinks() {
        return drinkRepository.findAll();
    }

    @Override
    public Drink findDrinkByName(String name) {
        return drinkRepository.findByName(name.toLowerCase(Locale.ROOT));
    }
}
