package com.trendsense.market.ai.controller;

import com.trendsense.market.ai.dto.ApiResponse;
import com.trendsense.market.ai.dto.CreateHoldingRequest;
import com.trendsense.market.ai.dto.HoldingResponse;
import com.trendsense.market.ai.service.HoldingService;
import org.springframework.web.bind.annotation.*;

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
}