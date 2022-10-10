package com.butr1m.delivery.controller.rest;

import com.butr1m.delivery.service.OrderService;
import com.butr1m.delivery.view.OrderView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-rest")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @GetMapping("/find-all-order")
    public ResponseEntity<List<OrderView>> findAllOrders() {
        return ResponseEntity.ok(orderService.findAllOrder());
    }

    @PostMapping("/save-order")
    public ResponseEntity saveOrder(@RequestBody OrderView orderView) {
        OrderView view = orderService.saveNewOrder(orderView);
        if (view != null) {
           return ResponseEntity.ok(view);
        }
        return ResponseEntity.badRequest().body("Fail");
    }

    @PostMapping("/save-edited-order")
    public ResponseEntity saveEditedOrder(@RequestBody OrderView orderView) {
        List<OrderView> views = orderService.saveEditedOrder(orderView);
        if (views != null) {
            return ResponseEntity.ok(views);
        }
        return ResponseEntity.badRequest().body("Fail");
    }

    @GetMapping("/get-order-on-today")
    public ResponseEntity getOrderOnToday(){
        List<OrderView> list = orderService.getOrderOnToday();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/change-delivery-status")
    public ResponseEntity changeDeliveryOrderStatus(@RequestBody OrderView view){
        OrderView orderView = orderService.changeOrderDeliveryStatus(view);
        return ResponseEntity.ok(orderView);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<OrderView>> deleteOrder(@PathVariable Long id){
        return ResponseEntity.ok(orderService.delete(id));
    }
}
