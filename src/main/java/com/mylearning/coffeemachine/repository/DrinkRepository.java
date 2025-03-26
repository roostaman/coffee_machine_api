package com.mylearning.coffeemachine.repository;

import com.mylearning.coffeemachine.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

    Drink findByName(String drink);
}
