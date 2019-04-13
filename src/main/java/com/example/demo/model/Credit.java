package com.example.demo.model;

import org.hibernate.type.descriptor.java.JdbcTimestampTypeDescriptor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "credit_1")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private Client client;
    private String title;
    private String currency;
    private Boolean isPaid;
    private Double amount;
    private Integer termMonths;
    private Double ratePercentage;
    private Timestamp timestamp;

    public Credit(){
        
    }

    public Credit(Client client, String title, String currency, Double amount, Integer termMonths, Double ratePercentage, Timestamp timestamp) {
        this.id = id;
        this.client = client;
        this.title = title;
        this.currency = currency;
        this.isPaid = isPaid;
        this.amount = amount;
        this.termMonths = termMonths;
        this.ratePercentage = ratePercentage;
        this.timestamp = timestamp;
        client.addCreditToList(this);
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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

