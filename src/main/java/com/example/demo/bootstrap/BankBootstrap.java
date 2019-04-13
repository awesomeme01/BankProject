package com.example.demo.bootstrap;

import com.example.demo.model.Bank;
import com.example.demo.model.Client;
import com.example.demo.model.Credit;
import com.example.demo.repository.BankRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.CreditRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BankBootstrap implements CommandLineRunner {
    private final BankRepository bankRepository;
    private final ClientRepository clientRepository;
    private final CreditRepository creditRepository;

    public BankBootstrap(BankRepository bankRepository, ClientRepository clientRepository, CreditRepository creditRepository) {
        this.bankRepository = bankRepository;
        this.clientRepository = clientRepository;
        this.creditRepository = creditRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Bank bank1 = new Bank("BakaiBank");
        bankRepository.save(bank1);
        Client client1 = new Client("Medet uulu Shabdan");
        Client client2 = new Client("Kasymov Temirlan");
        Client client3 = new Client("Pamirbek Almazov");
        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);
        Credit credit1 = new Credit(client1,"MicroCompanyCredit","USD",12000.0,12,15.0,null);
        Credit credit2 = new Credit(client1,"BussinessProperty","USD",5000.0,8,10.0,null);
        Credit credit3 = new Credit(client2,"Estate","EUR",1400.0,9,5.0,null);
        Credit credit4 = new Credit(client3,"Ipoteka","SOM",12000.0,4,20.0,null);
        creditRepository.save(credit1);
        creditRepository.save(credit2);
        creditRepository.save(credit3);
        creditRepository.save(credit4);

    }
}
