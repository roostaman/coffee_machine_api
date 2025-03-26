package com.mylearning.coffeemachine.service;

import com.mylearning.coffeemachine.model.Drink;
import com.mylearning.coffeemachine.model.DrinkStat;
import com.mylearning.coffeemachine.model.Order;
import com.mylearning.coffeemachine.repository.DrinkStatRepository;
import com.mylearning.coffeemachine.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
//@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private DrinkStatRepository drinkStatRepository;

    public OrderServiceImpl(OrderRepository orderRepository, DrinkStatRepository drinkStatRepository) {
        this.orderRepository = orderRepository;
        this.drinkStatRepository = drinkStatRepository;
    }

    @Override
    public Order saveOrder(Drink theDrink) {
//        Order order = new Order();
//        order.setDrink(theDrink);
//        order.setOrderDate(LocalDateTime.now());

        Order order = new Order(theDrink, LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public void updateStats(Drink theDrink) {
        DrinkStat drinkStat = drinkStatRepository.findByName(theDrink.getName());

        if (drinkStat != null) {
            drinkStat.setCount(drinkStat.getCount() + 1);
        } else {
            drinkStat = new DrinkStat(theDrink.getName(), 1);
        }
        drinkStatRepository.save(drinkStat);
    }

    @Cacheable("popular_drink")
    @Override
    public DrinkStat getMostPopularDrink() {
        return drinkStatRepository.findPopularDrinkByCount();
    }
}
