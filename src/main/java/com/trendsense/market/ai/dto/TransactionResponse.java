package com.trendsense.market.ai.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {

    private Long id;
    private Long holdingId;
    private String transactionType;
    private BigDecimal quantity;
    private BigDecimal pricePerUnit;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;

    public TransactionResponse(
            Long id,
            Long holdingId,
            String transactionType,
            BigDecimal quantity,
            BigDecimal pricePerUnit,
            BigDecimal totalAmount,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.holdingId = holdingId;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getHoldingId() {
        return holdingId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}