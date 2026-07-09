package com.trendsense.market.ai.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HoldingResponse {

    private Long id;
    private Long portfolioId;
    private String symbol;
    private String assetType;
    private BigDecimal quantity;
    private BigDecimal averageBuyPrice;
    private LocalDateTime createdAt;

    public HoldingResponse(
            Long id,
            Long portfolioId,
            String symbol,
            String assetType,
            BigDecimal quantity,
            BigDecimal averageBuyPrice,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.portfolioId = portfolioId;
        this.symbol = symbol;
        this.assetType = assetType;
        this.quantity = quantity;
        this.averageBuyPrice = averageBuyPrice;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getAssetType() {
        return assetType;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getAverageBuyPrice() {
        return averageBuyPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}