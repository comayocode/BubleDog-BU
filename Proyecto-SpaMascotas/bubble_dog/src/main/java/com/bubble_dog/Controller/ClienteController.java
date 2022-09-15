package com.bubble_dog.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bubble_dog.Models.ClienteModel;
import com.bubble_dog.Services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    

    private ClienteService service;

    public ClienteController() {
        service = new ClienteService();
    }

    @PostMapping
    public String create(@RequestBody ClienteModel cliente) {
        return service.create(cliente);
    }
}
