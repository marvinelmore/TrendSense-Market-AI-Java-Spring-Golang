package com.trendsense.market.ai.service;

import com.trendsense.market.ai.dto.CreateTransactionRequest;
import com.trendsense.market.ai.dto.TransactionResponse;

import java.util.List;

public interface TransactionService {

    TransactionResponse createTransaction(CreateTransactionRequest request);

    List<TransactionResponse> getTransactionsByHoldingId(Long holdingId);

    TransactionResponse getTransactionById(Long id);
}