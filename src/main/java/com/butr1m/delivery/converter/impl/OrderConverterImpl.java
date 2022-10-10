package com.butr1m.delivery.converter.impl;

import com.butr1m.delivery.converter.OrderConverter;
import com.butr1m.delivery.entity.Order;
import com.butr1m.delivery.view.OrderView;
import org.springframework.stereotype.Component;

@Component
public class OrderConverterImpl implements OrderConverter {
    @Override
    public Order viewToEntity(OrderView view) {
        return Order.builder()
                .id(view.getId())
                .clientName(view.getClientName())
                .phoneNumber(view.getPhoneNumber())
                .address(view.getAddress())
                .deliveryDate(view.getDeliveryDate())
                .amount(view.getAmount())
                .costPerKg(view.getCostPerKg())
                .cost(view.getCost())
                .comment(view.getComment())
                .delivered(view.getDelivered())
                .build();
    }

    @Override
    public OrderView entityToView(Order order) {
        return OrderView.builder()
                .id(order.getId())
                .clientName(order.getClientName())
                .phoneNumber(order.getPhoneNumber())
                .address(order.getAddress())
                .deliveryDate(order.getDeliveryDate())
                .amount(order.getAmount())
                .costPerKg(order.getCostPerKg())
                .cost(order.getCost())
                .comment(order.getComment())
                .delivered(order.getDelivered())
                .build();
    }
}
