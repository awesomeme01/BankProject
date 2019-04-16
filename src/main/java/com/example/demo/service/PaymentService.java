package com.example.demo.service;

import com.example.demo.model.Credit;
import com.example.demo.model.Payment;

import java.util.List;

public interface PaymentService {
    Credit makePayment(Payment payment);
    List<Payment> getPaymentHistory(Long creditId);
}
