package com.mylearning.coffeemachine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "drink_stats")
@Data
@NoArgsConstructor
public class DrinkStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String drinkName; // "water", "milk", "coffee"

    private int count;

    // define constructor without id
    public DrinkStat(String drinkName, int count) {
        this.drinkName = drinkName;
        this.count = count;
    }
}
