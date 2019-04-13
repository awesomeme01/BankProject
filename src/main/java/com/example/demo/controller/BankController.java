package com.example.demo.controller;

import com.example.demo.model.Bank;
import com.example.demo.model.Client;
import com.example.demo.model.Credit;
import com.example.demo.service.BankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BankController.URl_BANK)
public class BankController {
    public static final String URl_BANK = "/api/bank";
    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }
    @GetMapping
    public Bank getBankById(){
        return this.bankService.getBankById(Integer.toUnsignedLong(1));
    }
    @GetMapping("/credits")
    public List<Credit> getCredits(){
        return this.bankService.getCredits();
    }
    @GetMapping("/paidCredits")
    public List<Credit> getPaidCredits(){
        return this.bankService.getPaidCredits();
    }
    @GetMapping("/unPaidCredits")
    public List<Credit> getUnPaidCredits(){
        return this.bankService.getUnPaidCredits();
    }
    @GetMapping("/outDatedCredits")
    public List<Credit> getOutDatedCredits(){
        return this.bankService.getOutDatedCredits();
    }
    @GetMapping("/credits/{id}")
    public Credit getCreditById(@PathVariable Long id){
        return this.bankService.getCreditById(id);
    }
    @GetMapping("/clients")
    public List<Client> getClients(){
        return this.bankService.getClients();
    }
    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable Long id){
        return this.bankService.getClientById(id);
    }
    @PostMapping("/credits")
    public Credit createCredit(@RequestBody Credit credit){
        return this.bankService.createCredit(credit);
    }
    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client){
        return this.bankService.createClient(client);
    }
    @DeleteMapping("/credits/{id}")
    public void deleteCredit(@PathVariable Long id){
        this.bankService.deleteCredit(id);
    }
    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id){
        this.bankService.deleteClient(id);
    }
    @PutMapping("/credit/{id}")
    public Credit makePayment(@PathVariable Long id){
        this.bankService.makePayment(,id)
    }

}
