package com.butr1m.delivery.view;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderView {
    private Long id;
    private String clientName;
    private String phoneNumber;
    private String address;
    private LocalDateTime deliveryDate;
    private Double amount;
    private Double costPerKg;
    private Double cost;
    private String comment;
    private Boolean delivered;
}
