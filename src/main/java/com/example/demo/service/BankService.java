package com.example.demo.service;

import com.example.demo.model.Bank;
import com.example.demo.model.Client;
import com.example.demo.model.Credit;

import java.util.List;

public interface BankService {
    Bank getBankById(Long id);
    List<Credit> getCredits();
    List<Credit> getPaidCredits();
    List<Credit> getUnPaidCredits();
    List<Credit> getOutDatedCredits();
    Credit getCreditById(Long id);
    List<Client> getClients();
    Client getClientById(Long id);
    Credit createCredit(Credit credit);
    Client createClient(Client client);
    void deleteCredit(Long id);
    void deleteClient(Long id);
    Credit makePayment(Double amount, Long id);


}
