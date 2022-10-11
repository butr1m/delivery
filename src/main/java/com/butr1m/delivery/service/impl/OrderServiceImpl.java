package com.butr1m.delivery.service.impl;

import com.butr1m.delivery.converter.OrderConverter;
import com.butr1m.delivery.entity.Client;
import com.butr1m.delivery.entity.Order;
import com.butr1m.delivery.repository.OrderRepository;
import com.butr1m.delivery.service.ClientService;
import com.butr1m.delivery.service.OrderService;
import com.butr1m.delivery.view.OrderView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;
    private final ClientService clientService;

    @Override
    public List<OrderView> findAllOrder() {
        return orderRepository.returnAllOrders()
                .stream()
                .map(orderConverter::entityToView)
                .collect(Collectors.toList());
    }

    @Override
    public OrderView saveNewOrder(OrderView orderView) {
        Order order = orderConverter.viewToEntity(orderView);
        clientService.saveClient(createClient(orderView));
        return orderConverter.entityToView(orderRepository.save(order));
    }

    @Override
    public List<OrderView> saveEditedOrder(OrderView orderView) {
        Order order = orderConverter.viewToEntity(orderView);
        orderRepository.save(order);
        return getOrderOnToday();
    }

    @Override
    public List<OrderView> delete(Long id) {
        orderRepository.deleteById(id);
        return getOrderOnToday();
    }

    @Override
    public List<OrderView> getOrderOnToday() {
        LocalDateTime dayStart = LocalDateTime.now().toLocalDate().atStartOfDay();
        LocalDateTime dayEnd = dayStart.plusDays(1);
        List<Order> orders = orderRepository.returnAllOrderOnToday(dayStart, dayEnd);
        return orders
                .stream()
                .map(orderConverter::entityToView)
                .collect(Collectors.toList());
    }

    @Override
    public OrderView changeOrderDeliveryStatus(OrderView view) {
        Order order = orderRepository.findById(view.getId()).orElse(null);
        order.setDelivered(view.getDelivered());
        return orderConverter.entityToView(orderRepository.save(order));
    }

    private Client createClient(OrderView orderView) {
        return Client.builder()
                .id(null)
                .name(orderView.getClientName())
                .phoneNumber(orderView.getPhoneNumber())
                .address(orderView.getAddress())
                .build();
    }
}
