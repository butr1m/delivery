package com.butr1m.delivery.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ClientController {

    @RequestMapping("/client-page")
    public String getClientPage() {
        return "client-page";
    }
}
