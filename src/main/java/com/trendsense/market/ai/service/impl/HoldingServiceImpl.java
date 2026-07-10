package com.trendsense.market.ai.service.impl;

import com.trendsense.market.ai.dto.CreateHoldingRequest;
import com.trendsense.market.ai.dto.HoldingResponse;
import com.trendsense.market.ai.dto.UpdateHoldingRequest;
import com.trendsense.market.ai.entity.Holding;
import com.trendsense.market.ai.entity.Portfolio;
import com.trendsense.market.ai.exception.ResourceNotFoundException;
import com.trendsense.market.ai.repository.HoldingRepository;
import com.trendsense.market.ai.repository.PortfolioRepository;
import com.trendsense.market.ai.service.HoldingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoldingServiceImpl implements HoldingService {

    private final HoldingRepository holdingRepository;
    private final PortfolioRepository portfolioRepository;

    public HoldingServiceImpl(
            HoldingRepository holdingRepository,
            PortfolioRepository portfolioRepository
    ) {
        this.holdingRepository = holdingRepository;
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public HoldingResponse createHolding(CreateHoldingRequest request) {
        Portfolio portfolio = portfolioRepository.findById(request.getPortfolioId())
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found with id: " + request.getPortfolioId()));

        Holding holding = new Holding(
                request.getSymbol(),
                request.getAssetType(),
                request.getQuantity(),
                request.getAverageBuyPrice(),
                portfolio
        );

        Holding savedHolding = holdingRepository.save(holding);

        return mapToResponse(savedHolding);
    }

    @Override
    public List<HoldingResponse> getHoldingsByPortfolioId(Long portfolioId) {
        return holdingRepository.findByPortfolioId(portfolioId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public HoldingResponse getHoldingById(Long id) {
        Holding holding = holdingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holding not found with id: " + id));

        return mapToResponse(holding);
    }

    private HoldingResponse mapToResponse(Holding holding) {
        return new HoldingResponse(
                holding.getId(),
                holding.getPortfolio().getId(),
                holding.getSymbol(),
                holding.getAssetType(),
                holding.getQuantity(),
                holding.getAverageBuyPrice(),
                holding.getCreatedAt()
        );
    }

    @Override
    public HoldingResponse updateHolding(Long id, UpdateHoldingRequest request) {
        Holding holding = holdingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holding not found with id: " + id));

        holding.setSymbol(request.getSymbol());
        holding.setAssetType(request.getAssetType());
        holding.setQuantity(request.getQuantity());
        holding.setAverageBuyPrice(request.getAverageBuyPrice());
        holding.markUpdated();

        Holding updatedHolding = holdingRepository.save(holding);

        return mapToResponse(updatedHolding);
    }

    @Override
    public void deleteHolding(Long id) {
        Holding holding = holdingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holding not found with id: " + id));

        holdingRepository.delete(holding);
    }

}