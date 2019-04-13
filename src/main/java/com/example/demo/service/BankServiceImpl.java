package com.example.demo.service;

import com.example.demo.model.Bank;
import com.example.demo.model.Client;
import com.example.demo.model.Credit;
import com.example.demo.model.Payment;
import com.example.demo.repository.BankRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BankServiceImpl implements BankService{
    private final BankRepository bankRepository;
    private final ClientRepository clientRepository;
    private final CreditRepository creditRepository;

    public BankServiceImpl(BankRepository bankRepository, ClientRepository clientRepository, CreditRepository creditRepository) {
        this.bankRepository = bankRepository;
        this.clientRepository = clientRepository;
        this.creditRepository = creditRepository;
    }

    @Override
    public List<Credit> getOutDatedCredits() {
        return null;
    }

    @Override
    public Bank getBankById(Long id) {
        return bankRepository.findById(id).get();
    }

    @Override
    public List<Credit> getCredits() {
        return creditRepository.findAll();
    }

    @Override
    public List<Credit> getPaidCredits() {
        return creditRepository.findAll().stream().filter(x->x.getPaid()).collect(Collectors.toList());
    }

    @Override
    public List<Credit> getUnPaidCredits() {
        return creditRepository.findAll().stream().filter(x->!x.getPaid()).collect(Collectors.toList());
    }

//    @Override
//    public List<Credit> getOutDatedCredits() {
//        return creditRepository.findAll().stream().filter(x->{
//            if(x.)
//        }).collect(Collectors.toList());
//    }

    @Override
    public Credit getCreditById(Long id) {
        return creditRepository.findById(id).get();
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Credit createCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteCredit(Long id) {
        creditRepository.delete(creditRepository.findById(id).get());
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.delete(clientRepository.findById(id).get());
    }

    @Override
    public Credit makePayment(Payment payment) {
        Double oldAmount = payment.getAmount();
        if(oldAmount>=payment.getAmount()) {
            payment.getCredit().setAmount(oldAmount - payment.getAmount());
            if(payment.getCredit().getAmount() == 0){
                payment.getCredit().setPaid(true);
            }
        }
        else{
            System.out.println("You're trying to pay more than you have to!!!!");
            throw new IllegalArgumentException("Entered payment is greater than the actual amount of the credit needed to be paid!!!!");
        }
        return creditRepository.save(payment.getCredit());
    }
}
