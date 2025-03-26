package com.mylearning.coffeemachine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "drinks")
//@Data
//@NoArgsConstructor
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

    public Drink() {
    }

    // CUSTOM GETTER SETTERS

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

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", water=" + water +
                ", milk=" + milk +
                ", coffee=" + coffee +
                '}';
    }
}
