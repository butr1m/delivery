package com.butr1m.delivery.service;

import com.butr1m.delivery.view.OrderView;

import java.util.List;

public interface OrderService {

    List<OrderView> findAllOrder();

    OrderView saveNewOrder(OrderView orderView);

    List<OrderView> getOrderOnToday();

    OrderView changeOrderDeliveryStatus(OrderView view);

    List<OrderView> saveEditedOrder(OrderView orderView);

    List<OrderView> delete(Long id);

}
