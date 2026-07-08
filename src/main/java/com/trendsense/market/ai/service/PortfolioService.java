package com.trendsense.market.ai.service;

import com.trendsense.market.ai.dto.CreatePortfolioRequest;
import com.trendsense.market.ai.dto.PortfolioResponse;

import java.util.List;

public interface PortfolioService {

    PortfolioResponse createPortfolio(CreatePortfolioRequest request);

    List<PortfolioResponse> getPortfoliosByUserId(Long userId);

    PortfolioResponse getPortfolioById(Long id);
}