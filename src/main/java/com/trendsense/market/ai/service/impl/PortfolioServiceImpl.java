package com.trendsense.market.ai.service.impl;

import com.trendsense.market.ai.dto.CreatePortfolioRequest;
import com.trendsense.market.ai.dto.PortfolioResponse;
import com.trendsense.market.ai.entity.Portfolio;
import com.trendsense.market.ai.entity.User;
import com.trendsense.market.ai.exception.ResourceNotFoundException;
import com.trendsense.market.ai.repository.PortfolioRepository;
import com.trendsense.market.ai.repository.UserRepository;
import com.trendsense.market.ai.service.PortfolioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public PortfolioServiceImpl(
            PortfolioRepository portfolioRepository,
            UserRepository userRepository
    ) {
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PortfolioResponse createPortfolio(CreatePortfolioRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + request.getUserId()));

        Portfolio portfolio = new Portfolio(
                request.getName(),
                request.getDescription(),
                user
        );

        Portfolio savedPortfolio = portfolioRepository.save(portfolio);

        return mapToResponse(savedPortfolio);
    }

    @Override
    public List<PortfolioResponse> getPortfoliosByUserId(Long userId) {
        return List.of();
    }

    @Override
    public PortfolioResponse getPortfolioById(Long id) {
        return null;
    }

    private PortfolioResponse mapToResponse(Portfolio portfolio) {
        return new PortfolioResponse(
                portfolio.getId(),
                portfolio.getName(),
                portfolio.getDescription(),
                portfolio.getUser().getId(),
                portfolio.getCreatedAt()
        );
    }
}