package com.example.demo.service;

import com.example.demo.model.Credit;

import java.util.List;

public interface CreditService {
    List<Credit> getCredits();
    Credit getCreditById(Long id);
    List<Credit> getPaidCredits();
    List<Credit> getUnPaidCredits();
    List<Credit> getOutDatedCredits();
    Credit createCredit(Credit credit);
    void deleteCredit(Long id);

}
