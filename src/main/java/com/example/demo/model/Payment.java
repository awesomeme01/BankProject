package com.example.demo.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double amount;
    private Time time;

    public Payment() {
    }

    public Payment(String description, Double amount, Time time) {
        this.description = description;
        this.amount = amount;
        this.time = time;
    }
}
