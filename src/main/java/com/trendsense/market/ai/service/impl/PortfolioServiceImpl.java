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
import com.trendsense.market.ai.dto.UpdatePortfolioRequest;

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
        return portfolioRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public PortfolioResponse getPortfolioById(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found with id: " + id));

        return mapToResponse(portfolio);
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

    @Override
    public PortfolioResponse updatePortfolio(Long id, UpdatePortfolioRequest request) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found with id: " + id));

        portfolio.setName(request.getName());
        portfolio.setDescription(request.getDescription());
        portfolio.markUpdated();

        Portfolio updatedPortfolio = portfolioRepository.save(portfolio);

        return mapToResponse(updatedPortfolio);
    }

    @Override
    public void deletePortfolio(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found with id: " + id));

        portfolioRepository.delete(portfolio);
    }

}