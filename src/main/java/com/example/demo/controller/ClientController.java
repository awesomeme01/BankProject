package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ClientController.url)
public class ClientController {
    public static final String url = "/api/clients";
    @Autowired
    private ClientService clientService;
    /*
    List<Client> getClients();
    Client getClientById(Long id);
    Client createClient(Client client);
    void deleteClient(Long id);
    */
    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }


}
