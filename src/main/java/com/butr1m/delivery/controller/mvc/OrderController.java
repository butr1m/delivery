package com.butr1m.delivery.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class OrderController {

    @RequestMapping("/order-page")
    public String getOrderPage() {
        return "order-page";
    }

    @RequestMapping("/order-on-today")
    public String orderOnToday() {
        return "order-today-page";
    }

    @RequestMapping("/all-orders")
    public String allOrders() {
        return "all-orders-page";
    }
}
