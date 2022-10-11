package com.butr1m.delivery.converter;

import com.butr1m.delivery.entity.Client;
import com.butr1m.delivery.view.ClientView;

public interface ClientConverter {
    ClientView entityToView(Client client);
}
