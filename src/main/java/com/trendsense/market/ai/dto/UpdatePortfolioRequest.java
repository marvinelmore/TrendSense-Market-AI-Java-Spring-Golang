package com.trendsense.market.ai.dto;

public class UpdatePortfolioRequest {

    private String name;
    private String description;

    public UpdatePortfolioRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}