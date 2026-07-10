package com.trendsense.market.ai.service;

import com.trendsense.market.ai.dto.CreateHoldingRequest;
import com.trendsense.market.ai.dto.HoldingResponse;
import com.trendsense.market.ai.dto.UpdateHoldingRequest;

import java.util.List;

public interface HoldingService {

    HoldingResponse createHolding(CreateHoldingRequest request);

    List<HoldingResponse> getHoldingsByPortfolioId(Long portfolioId);

    HoldingResponse getHoldingById(Long id);

    HoldingResponse updateHolding(Long id, UpdateHoldingRequest request);

    void deleteHolding(Long id);
}