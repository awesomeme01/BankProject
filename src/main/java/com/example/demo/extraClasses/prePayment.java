package com.example.demo.extraClasses;

import com.example.demo.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class prePayment {
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDateTime time;
    private PaymentStatus paymentStatus;

    public prePayment(Long id, String description, BigDecimal amount, LocalDateTime time, PaymentStatus paymentStatus) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.time = time;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
