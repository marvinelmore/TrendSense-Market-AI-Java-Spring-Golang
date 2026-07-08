package com.trendsense.market.ai.controller;

import com.trendsense.market.ai.dto.ApiResponse;
import com.trendsense.market.ai.dto.CreatePortfolioRequest;
import com.trendsense.market.ai.dto.PortfolioResponse;
import com.trendsense.market.ai.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping
    public ApiResponse<PortfolioResponse> createPortfolio(@RequestBody CreatePortfolioRequest request) {
        PortfolioResponse portfolio = portfolioService.createPortfolio(request);

        return ApiResponse.success("Portfolio created successfully", portfolio);
    }
}