package com.example.demo.service;

import com.example.demo.enums.PaymentStatus;
import com.example.demo.model.Credit;
import com.example.demo.model.Payment;
import com.example.demo.repository.CreditRepository;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CreditRepository creditRepository;

    @Override
    public Credit makePayment(Payment payment) {

        BigDecimal oldAmount = payment.getCredit().getAmount();
        payment.setPaymentStatus(PaymentStatus.AWAITING_CONFIRMATION);

        if(oldAmount.compareTo(payment.getAmount())>0) {
            payment.getCredit().setAmount(oldAmount.subtract(payment.getAmount()));
            payment.setTime(LocalDateTime.now());
            paymentRepository.save(payment);
            if(payment.getCredit().getAmount().compareTo(BigDecimal.ZERO)== 0){
                payment.getCredit().setPaid(true);
            }
        }
        else{
            System.out.println("You're trying to pay more than you have to!!!!");
            throw new IllegalArgumentException("Entered payment is greater than the actual amount of the credit needed to be paid!!!!");
        }
        return creditRepository.save(payment.getCredit());
    }

    @Override
    public List<Payment> getPaymentHistory(Long creditId) {
        List<Payment> payments = paymentRepository.findAll()
                .stream()
                .filter(
                        x->x.getCredit().getId().equals(creditId)
                ).collect(Collectors.toList());

        return payments;
    }
}
