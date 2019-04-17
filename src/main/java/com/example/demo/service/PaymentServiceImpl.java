package com.example.demo.service;

import com.example.demo.enums.PaymentStatus;
import com.example.demo.extraClasses.prePayment;
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
import java.util.Random;
import java.util.stream.Collectors;
@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CreditRepository creditRepository;
    Random rand = new Random();
    @Override
    public Payment beginPayment(Payment payment) {
        if(validatePayment(payment)) {
            payment.setPaymentStatus(PaymentStatus.AWAITING_CONFIRMATION);
            payment.setTime(LocalDateTime.now());
            //test
            payment.setConfirmationCode(rand.nextInt((999999 - 100000) + 1) + 100000);
            System.out.println("==========TESTING PAYMENT==========\nGenerating confirmation code...\nCODE:  " + payment.getConfirmationCode());
        }
        else{
            payment.setPaymentStatus(PaymentStatus.ERROR);
        }
        //Maybe I'll need to stop saving this payment here!
        return  paymentRepository.save(payment);
    }
    @Override
    public Payment confirmPayment(Long paymentId, Integer confirmationCode){
        Payment payment1 = paymentRepository.findById(paymentId).get();
        if(payment1.getConfirmationCode().equals(confirmationCode)){
            return paymentRepository.save(finishPayment(payment1));
        }
        return payment1;
    }
    private static Boolean validatePayment(Payment payment){
        BigDecimal oldAmount = payment.getCredit().getAmount();
        if(payment.getAmount().equals(BigDecimal.ZERO)){
            try{
                throw new IllegalArgumentException("Your payment amount cannot be zero!!!!");
            }catch (IllegalArgumentException ex){}
            return false;
        }
        if(oldAmount.compareTo(payment.getAmount())<0){
            try{
                throw new IllegalArgumentException("Entered payment is greater than the actual amount of the credit needed to be paid!!!!");
            }catch (IllegalArgumentException ex){}
            return false;

        }
        if(payment.getAmount().compareTo(BigDecimal.ZERO)<0){
            try{
                throw new IllegalArgumentException("Your payment amount cannot be a negative number");
            }catch (IllegalArgumentException ex){}
            return false;
        }
        return true;
    }
    private Payment finishPayment(Payment payment){
        BigDecimal oldAmount = payment.getCredit().getAmount();
        payment.getCredit().setAmount(oldAmount.subtract(payment.getAmount()));
        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        if (payment.getCredit().getAmount().compareTo(BigDecimal.ZERO) == 0) {
            payment.getCredit().setPaid(true);
        }
        creditRepository.save(payment.getCredit());
        return payment;
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