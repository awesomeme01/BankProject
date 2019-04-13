package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="client_1")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    @ElementCollection
    @CollectionTable(name="credit_1", joinColumns=@JoinColumn(name="credit_id"))
    @Column(name="credit")
    private List<Credit> credits;

    public Client(String fullname) {
        this.id = id;
        this.fullname = fullname;
    }
    public Credit addCreditToList(Credit credit){
        credits.add(credit);
        return credit;
    }
    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}
