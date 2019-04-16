package com.example.demo.service;

import com.example.demo.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getClients();
    Client getClientById(Long id);
    Client createClient(Client client);
    void deleteClient(Long id);
}
