package com.butr1m.delivery.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientView {

    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
}
