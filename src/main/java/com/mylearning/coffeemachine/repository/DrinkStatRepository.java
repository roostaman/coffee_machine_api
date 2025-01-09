package com.mylearning.coffeemachine.repository;

import com.mylearning.coffeemachine.model.DrinkStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DrinkStatRepository extends JpaRepository<DrinkStat, Long> {

    DrinkStat findByName(String name);

    @Query(value = "SELECT drink_id FROM drink_stat GROUP BY drink_id ORDER BY COUNT(drink_id) DESC LIMIT 1", nativeQuery = true)
    DrinkStat findPopularDrinkByCount();

}
