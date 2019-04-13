package com.example.demo.bootstrap;

import com.example.demo.model.Bank;
import com.example.demo.model.Client;
import com.example.demo.model.Credit;
import com.example.demo.model.Payment;
import com.example.demo.repository.BankRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.CreditRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;

@Component
public class BankBootstrap implements CommandLineRunner {
    @Autowired
    private BankService bankService;
    @Override
    public void run(String... args) throws Exception{
        Bank bank1 = new Bank("BakaiBank");
        bankService.createBank(bank1);
        Client client1 = new Client("Medet uulu Shabdan");
        Client client2 = new Client("Kasymov Temirlan");
        Client client3 = new Client("Pamirbek Almazov");
        bankService.createClient(client1);
        bankService.createClient(client2);
        bankService.createClient(client3);
        Credit credit1 = new Credit(client1,"MicroCompanyCredit","USD",BigDecimal.valueOf(12000.0),12,15.0,null);
        Credit credit2 = new Credit(client1,"BussinessProperty","USD",BigDecimal.valueOf(9000.0),8,10.0,null);
        Credit credit3 = new Credit(client2,"Estate","EUR",BigDecimal.valueOf(1300.0),9,5.0,null);
        Credit credit4 = new Credit(client3,"Ipoteka","SOM",BigDecimal.valueOf(12000.0),4,20.0,null);
        bankService.createCredit(credit1);
        bankService.createCredit(credit2);
        bankService.createCredit(credit3);
        bankService.createCredit(credit4);
        Payment payment1 = new Payment("new payment", BigDecimal.valueOf(250), LocalDateTime.now(),"1267476Sha",credit1);
        bankService.makePayment(payment1);
    }
}
