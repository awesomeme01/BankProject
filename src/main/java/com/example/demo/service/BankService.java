package com.example.demo.service;

import com.example.demo.model.Bank;
import com.example.demo.model.Client;
import com.example.demo.model.Credit;
import com.example.demo.model.Payment;

import java.util.List;

public interface BankService {
    Bank createBank(Bank bank);
    Bank getBankById(Long id);



}
