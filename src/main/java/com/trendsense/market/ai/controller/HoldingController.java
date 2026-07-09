package com.trendsense.market.ai.controller;

import com.trendsense.market.ai.dto.ApiResponse;
import com.trendsense.market.ai.dto.CreateHoldingRequest;
import com.trendsense.market.ai.dto.HoldingResponse;
import com.trendsense.market.ai.service.HoldingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class HoldingController {

    private final HoldingService holdingService;

    public HoldingController(HoldingService holdingService) {
        this.holdingService = holdingService;
    }

    @PostMapping
    public ApiResponse<HoldingResponse> createHolding(
            @RequestBody CreateHoldingRequest request) {

        HoldingResponse holding = holdingService.createHolding(request);

        return ApiResponse.success(
                "Holding created successfully",
                holding
        );
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ApiResponse<List<HoldingResponse>> getHoldingsByPortfolioId(@PathVariable Long portfolioId) {
        List<HoldingResponse> holdings = holdingService.getHoldingsByPortfolioId(portfolioId);

        return ApiResponse.success("Holdings retrieved successfully", holdings);
    }

    @GetMapping("/{id}")
    public ApiResponse<HoldingResponse> getHoldingById(@PathVariable Long id) {
        HoldingResponse holding = holdingService.getHoldingById(id);

        return ApiResponse.success("Holding retrieved successfully", holding);
    }
}