package com.example.demo.repository;

import com.example.demo.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
