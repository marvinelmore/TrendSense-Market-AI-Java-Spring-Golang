package com.trendsense.market.ai.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionType;
    private BigDecimal quantity;
    private BigDecimal pricePerUnit;
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "holding_id", nullable = false)
    private Holding holding;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Transaction() {
    }

    public Transaction(
            String transactionType,
            BigDecimal quantity,
            BigDecimal pricePerUnit,
            BigDecimal totalAmount,
            Holding holding
    ) {
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalAmount = totalAmount;
        this.holding = holding;
    }

    public Long getId() {
        return id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public Holding getHolding() {
        return holding;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}