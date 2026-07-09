package com.trendsense.market.ai.service;

import com.trendsense.market.ai.dto.CreatePortfolioRequest;
import com.trendsense.market.ai.dto.PortfolioResponse;
import com.trendsense.market.ai.dto.UpdatePortfolioRequest;

import java.util.List;

public interface PortfolioService {

    PortfolioResponse createPortfolio(CreatePortfolioRequest request);

    List<PortfolioResponse> getPortfoliosByUserId(Long userId);

    PortfolioResponse getPortfolioById(Long id);

    PortfolioResponse updatePortfolio(Long id, UpdatePortfolioRequest request);

    void deletePortfolio(Long id);
}