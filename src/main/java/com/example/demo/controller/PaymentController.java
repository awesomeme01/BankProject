package com.example.demo.controller;

import com.example.demo.extraClasses.prePayment;
import com.example.demo.model.Credit;
import com.example.demo.model.Payment;
import com.example.demo.model.Response;
import com.example.demo.service.CreditService;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(PaymentController.url)
public class PaymentController {
    public static final String url = "/api/payments";
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private CreditService creditService;

    @PostMapping("/credit/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Payment beginPayment(@PathVariable Long id, @RequestBody Payment payment){
        payment.setCredit(creditService.getCreditById(id));
        return this.paymentService.beginPayment(payment);
    }
    @GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Payment> getPaymentHistory(@PathVariable Long id){
        return this.paymentService.getPaymentHistory(id);
    }
    @PutMapping("/confirmPayment/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Payment confirmPayment(@PathVariable Long id, @RequestBody Confirmation confirmation){
        return paymentService.confirmPayment(id,confirmation.confirmationCode);
    }
}
class Confirmation{
    Long paymentId;
    Integer confirmationCode;
    public Confirmation(){

    }
    public Confirmation(Long paymentId, Integer confirmationCode) {
        this.paymentId = paymentId;
        this.confirmationCode = confirmationCode;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(Integer confirmationCode) {
        this.confirmationCode = confirmationCode;
    }
}
