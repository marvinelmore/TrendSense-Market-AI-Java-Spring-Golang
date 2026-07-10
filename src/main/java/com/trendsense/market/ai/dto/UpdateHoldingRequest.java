package com.trendsense.market.ai.dto;

import java.math.BigDecimal;

public class UpdateHoldingRequest {

    private String symbol;
    private String assetType;
    private BigDecimal quantity;
    private BigDecimal averageBuyPrice;

    public UpdateHoldingRequest() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public BigDecimal getQuantity(){
        return quantity;
    }

    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }

    public BigDecimal getAverageBuyPrice() {
        return averageBuyPrice;
    }

    public void setAverageBuyPrice(BigDecimal averageBuyPrice) {
        this.averageBuyPrice = averageBuyPrice;
    }
}
