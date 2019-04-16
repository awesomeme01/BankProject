package com.example.demo.service;

import com.example.demo.model.Bank;
import com.example.demo.model.Client;
import com.example.demo.model.Credit;
import com.example.demo.model.Payment;
import com.example.demo.repository.BankRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BankServiceImpl implements BankService{

    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CreditRepository creditRepository;


    @Override
    public Bank createBank(Bank bank) {
        return this.bankRepository.save(bank);
    }


    @Override
    public Bank getBankById(Long id) {
        return bankRepository.findById(id).get();
    }



//    @Override
//    public List<Credit> getOutDatedCredits() {
//        return creditRepository.findAll().stream().filter(x->{
//            if(x.)
//        }).collect(Collectors.toList());
//    }




}
