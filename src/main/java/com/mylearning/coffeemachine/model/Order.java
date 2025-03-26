package com.mylearning.coffeemachine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
//@Data
//@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "drink_id", nullable = false)
    @JoinColumn(name = "drink_id")
    private Drink drink;

//    @Column(nullable = false)
    private LocalDateTime orderDate;

    // define constructor without id
    public Order(Drink drink, LocalDateTime orderDate) {
        this.drink = drink;
        this.orderDate = orderDate;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", drink=" + drink +
                ", orderDate=" + orderDate +
                '}';
    }
}
