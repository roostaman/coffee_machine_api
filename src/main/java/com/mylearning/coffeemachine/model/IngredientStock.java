package com.mylearning.coffeemachine.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingredient_stock")
@Data
@NoArgsConstructor
public class IngredientStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // "water", "milk", "coffee"

    @Column(nullable = false)
    @PositiveOrZero(message = "Quantity must be zero or positive")
    private Integer quantity; // in ml or grams

    // define constructor without id
    public IngredientStock(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
