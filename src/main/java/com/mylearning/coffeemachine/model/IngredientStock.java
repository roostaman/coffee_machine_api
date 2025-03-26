package com.mylearning.coffeemachine.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingredient_stock")
//@Data
//@NoArgsConstructor
public class IngredientStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, unique = true)
    @Column(unique = true)
    private String name; // "water", "milk", "coffee"

//    @Column(nullable = false)
    @PositiveOrZero(message = "Quantity must be zero or positive")
    private Integer quantity; // in ml or grams

    // define constructor without id
    public IngredientStock(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public IngredientStock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @PositiveOrZero(message = "Quantity must be zero or positive") Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@PositiveOrZero(message = "Quantity must be zero or positive") Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "IngredientStock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
