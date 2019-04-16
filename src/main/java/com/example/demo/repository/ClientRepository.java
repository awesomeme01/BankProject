package com.example.demo.repository;

import com.example.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

public interface ClientRepository extends JpaRepository<Client,Long> {
//    @Query(value = "select sum(p.amount) from Payment p inner join p.client c where c.id = :client_id")
//    BigDecimal getSumOfPayments(@Param("client_id") Long client_id);
}
