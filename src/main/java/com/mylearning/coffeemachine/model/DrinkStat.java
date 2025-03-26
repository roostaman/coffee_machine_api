package com.mylearning.coffeemachine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "drink_stats")
//@Data
//@NoArgsConstructor
public class DrinkStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, unique = true)
    @Column(unique = true)
    private String drinkName; // "water", "milk", "coffee"

    private int count;

    // define constructor without id
    public DrinkStat(String drinkName, int count) {
        this.drinkName = drinkName;
        this.count = count;
    }

    public DrinkStat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "DrinkStat{" +
                "id=" + id +
                ", drinkName='" + drinkName + '\'' +
                ", count=" + count +
                '}';
    }
}
