package com.butr1m.delivery.repository;

import com.butr1m.delivery.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o order by o.deliveryDate desc")
    List<Order> returnAllOrders();

    @Query("select o from Order o where o.deliveryDate>= :dayStart and o.deliveryDate<= :dayEnd order by o.deliveryDate")
    List<Order> returnAllOrderOnToday(@Param("dayStart") LocalDateTime dayStart, @Param("dayEnd") LocalDateTime dayEnd);
}
