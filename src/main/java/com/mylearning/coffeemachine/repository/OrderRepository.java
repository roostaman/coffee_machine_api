package com.mylearning.coffeemachine.repository;

import com.mylearning.coffeemachine.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long> {

    Order findByName(String name);
}
