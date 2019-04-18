package com.example.demo.model;

import org.hibernate.type.descriptor.java.JdbcTimestampTypeDescriptor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "credit_1")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    private String title;
    private String currency;
    private Boolean isPaid;
    private BigDecimal amount;
    private Integer termMonths;
    private Double ratePercentage;
    private LocalDateTime timestamp;

    public Credit(){
        
    }

    public Credit(String title, String currency, Boolean isPaid, BigDecimal amount, LocalDateTime timestamp) {
        this.title = title;
        this.currency = currency;
        this.isPaid = isPaid;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Credit(Client client, String title, String currency, BigDecimal amount, Integer termMonths, Double ratePercentage, LocalDateTime timestamp) {
        this.id = id;
        this.client = client;
        this.title = title;
        this.currency = currency;
        this.isPaid = isPaid;
        this.amount = amount;
        this.termMonths = termMonths;
        this.ratePercentage = ratePercentage;
        this.timestamp = timestamp;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getTermMonths() {
        return termMonths;
    }

    public void setTermMonths(Integer termMonths) {
        this.termMonths = termMonths;
    }

    public Double getRatePercentage() {
        return ratePercentage;
    }

    public void setRatePercentage(Double ratePercentage) {
        this.ratePercentage = ratePercentage;
    }
}

