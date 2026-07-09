package com.trendsense.market.ai.service.impl;

import com.trendsense.market.ai.dto.CreateTransactionRequest;
import com.trendsense.market.ai.dto.TransactionResponse;
import com.trendsense.market.ai.entity.Holding;
import com.trendsense.market.ai.entity.Transaction;
import com.trendsense.market.ai.exception.ResourceNotFoundException;
import com.trendsense.market.ai.repository.HoldingRepository;
import com.trendsense.market.ai.repository.TransactionRepository;
import com.trendsense.market.ai.service.TransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final HoldingRepository holdingRepository;

    public TransactionServiceImpl(
            TransactionRepository transactionRepository,
            HoldingRepository holdingRepository
    ) {
        this.transactionRepository = transactionRepository;
        this.holdingRepository = holdingRepository;
    }

    @Override
    public TransactionResponse createTransaction(CreateTransactionRequest request) {
        Holding holding = holdingRepository.findById(request.getHoldingId())
                .orElseThrow(() -> new ResourceNotFoundException("Holding not found with id: " + request.getHoldingId()));

        BigDecimal totalAmount = request.getQuantity().multiply(request.getPricePerUnit());

        Transaction transaction = new Transaction(
                request.getTransactionType(),
                request.getQuantity(),
                request.getPricePerUnit(),
                totalAmount,
                holding
        );

        Transaction savedTransaction = transactionRepository.save(transaction);

        return mapToResponse(savedTransaction);
    }

    @Override
    public List<TransactionResponse> getTransactionsByHoldingId(Long holdingId) {
        return transactionRepository.findByHoldingId(holdingId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public TransactionResponse getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Transaction not found with id: " + id));

        return mapToResponse(transaction);
    }

    private TransactionResponse mapToResponse(Transaction transaction) {
        return new TransactionResponse(
                transaction.getId(),
                transaction.getHolding().getId(),
                transaction.getTransactionType(),
                transaction.getQuantity(),
                transaction.getPricePerUnit(),
                transaction.getTotalAmount(),
                transaction.getCreatedAt()
        );
    }
}