package com.trendsense.market.ai.repository;

import com.trendsense.market.ai.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByHoldingId(Long holdingId);
}