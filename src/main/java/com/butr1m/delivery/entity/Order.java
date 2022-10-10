package com.butr1m.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "cost_per_kg")
    private Double costPerKg;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "comment")
    private String comment;

    @Column(name = "delivered")
    private Boolean delivered;
}
