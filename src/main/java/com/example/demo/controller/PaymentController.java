package com.example.demo.controller;

import com.example.demo.model.Credit;
import com.example.demo.model.Payment;
import com.example.demo.service.CreditService;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PaymentController.url)
public class PaymentController {
    public static final String url = "/api/payments";
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private CreditService creditService;

    @PutMapping("/credit/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Credit makePayment(@PathVariable Long id, @RequestBody Payment payment){
        payment.setCredit(creditService.getCreditById(id));
        return this.paymentService.makePayment(payment);
    }
    @GetMapping("/{id}")
    public List<Payment> getPaymentHistory(@PathVariable Long id){
        return this.paymentService.getPaymentHistory(id);
    }
}
