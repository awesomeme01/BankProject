package com.example.demo.service;

import com.example.demo.model.Credit;
import com.example.demo.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CreditServiceImpl implements CreditService{
    @Autowired
    private CreditRepository creditRepository;

    @Override
    public Credit createCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    @Override
    public void deleteCredit(Long id) {
        creditRepository.delete(creditRepository.findById(id).get());
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
    @Override
    public List<Credit> getOutDatedCredits() {
        return null;
    }

    @Override
    public Credit getCreditById(Long id) {
        return creditRepository.findById(id).get();
    }
}
