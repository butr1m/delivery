package com.butr1m.delivery.converter;

import com.butr1m.delivery.entity.Order;
import com.butr1m.delivery.view.OrderView;

public interface OrderConverter {

    Order viewToEntity(OrderView view);

    OrderView entityToView(Order order);
}
