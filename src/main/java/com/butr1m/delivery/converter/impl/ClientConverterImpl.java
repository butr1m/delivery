package com.butr1m.delivery.converter.impl;

import com.butr1m.delivery.converter.ClientConverter;
import com.butr1m.delivery.entity.Client;
import com.butr1m.delivery.view.ClientView;
import org.springframework.stereotype.Component;

@Component
public class ClientConverterImpl implements ClientConverter {

    @Override
    public ClientView entityToView(Client client) {
        return ClientView.builder()
                .id(client.getId())
                .name(client.getName())
                .phoneNumber(client.getPhoneNumber())
                .address(client.getAddress())
                .build();
    }
}
