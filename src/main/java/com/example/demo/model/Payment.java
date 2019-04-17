package com.example.demo.model;

import com.example.demo.enums.PaymentStatus;
import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDateTime time;
    private Integer confirmationCode;
    private PaymentStatus paymentStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "credit_id")
    private Credit credit;

    public Payment() {
    }


    public Payment(String description, BigDecimal amount, LocalDateTime time, Credit credit) {
        this.description = description;
        this.amount = amount;
        this.time = time;
        this.credit = credit;
    }

    public Integer getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(Integer confirmationCode){
        this.confirmationCode = confirmationCode;
    }
    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
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
}
