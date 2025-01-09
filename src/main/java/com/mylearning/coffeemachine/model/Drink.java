package com.mylearning.coffeemachine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "drinks")
@Data
@NoArgsConstructor
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private int water; // ml

    private int milk;  // ml

    private int coffee; // grams

    // define constructor without id
    public Drink(String name, int water, int milk, int coffee) {
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
    }
}
