package com.butr1m.delivery.controller.rest;

import com.butr1m.delivery.service.ClientService;
import com.butr1m.delivery.view.ClientView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients-rest/")
@RequiredArgsConstructor
public class ClientRestController {

    private final ClientService clientService;

    @GetMapping("find-all")
    public ResponseEntity<List<ClientView>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }
}
