package com.example.demo.service;

import com.example.demo.extraClasses.prePayment;
import com.example.demo.model.Credit;
import com.example.demo.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment beginPayment(Payment payment);
    List<Payment> getPaymentHistory(Long creditId);
    Payment confirmPayment(Long id ,Integer confirmationCode);
}
