package com.trendsense.market.ai.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "holdings")
public class Holding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private String assetType;
    private BigDecimal quantity;
    private BigDecimal averageBuyPrice;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    public Holding() {
    }

    public Holding(String symbol, String assetType, BigDecimal quantity, BigDecimal averageBuyPrice, Portfolio portfolio) {
        this.symbol = symbol;
        this.assetType = assetType;
        this.quantity = quantity;
        this.averageBuyPrice = averageBuyPrice;
        this.portfolio = portfolio;
    }

    public Long getId() {
        return id;
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

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void markUpdated() {
        this.updatedAt = LocalDateTime.now();
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setAverageBuyPrice(BigDecimal averageBuyPrice) {
        this.averageBuyPrice = averageBuyPrice;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

}