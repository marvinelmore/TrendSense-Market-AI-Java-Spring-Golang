package com.trendsense.market.ai.controller;

import com.trendsense.market.ai.dto.*;
import com.trendsense.market.ai.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/{userId}")
    public ApiResponse<List<PortfolioResponse>> getPortfoliosByUserId(@PathVariable Long userId) {
        List<PortfolioResponse> portfolios = portfolioService.getPortfoliosByUserId(userId);

        return ApiResponse.success("Portfolios retrieved successfully", portfolios);
    }

    @GetMapping("/{id}")
    public ApiResponse<PortfolioResponse> getPortfolioById(@PathVariable Long id) {
        PortfolioResponse portfolio = portfolioService.getPortfolioById(id);

        return ApiResponse.success("Portfolio retrieved successfully", portfolio);
    }

    @PutMapping("/{id}")
    public ApiResponse<PortfolioResponse> updatePortfolio(
            @PathVariable Long id,
            @RequestBody UpdatePortfolioRequest request) {

        PortfolioResponse portfolio = portfolioService.updatePortfolio(id, request);

        return ApiResponse.success(
                "Portfolio updated successfully",
                portfolio
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deletePortfolio(@PathVariable Long id) {
        portfolioService.deletePortfolio(id);

        return ApiResponse.success(
                "Portfolio deleted successfully",
                "Portfolio with id " + id + " was deleted"
        );
    }


}