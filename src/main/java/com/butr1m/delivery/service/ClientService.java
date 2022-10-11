package com.butr1m.delivery.service;

import com.butr1m.delivery.entity.Client;
import com.butr1m.delivery.view.ClientView;

import java.util.List;

public interface ClientService {

    ClientView saveClient(Client client);

    List<ClientView> findAll();
}
