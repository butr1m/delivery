package com.butr1m.delivery.service.impl;

import com.butr1m.delivery.converter.ClientConverter;
import com.butr1m.delivery.entity.Client;
import com.butr1m.delivery.repository.ClientRepository;
import com.butr1m.delivery.service.ClientService;
import com.butr1m.delivery.view.ClientView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientConverter clientConverter;
    private final ClientRepository clientRepository;

    @Override
    public ClientView saveClient(Client client) {
        return clientConverter.entityToView(clientRepository.save(client));
    }

    @Override
    public List<ClientView> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientConverter::entityToView)
                .collect(Collectors.toList());
    }
}
