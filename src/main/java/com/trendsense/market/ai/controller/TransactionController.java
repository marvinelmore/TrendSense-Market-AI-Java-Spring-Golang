package com.trendsense.market.ai.controller;

import com.trendsense.market.ai.dto.ApiResponse;
import com.trendsense.market.ai.dto.CreateTransactionRequest;
import com.trendsense.market.ai.dto.TransactionResponse;
import com.trendsense.market.ai.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ApiResponse<TransactionResponse> createTransaction(
            @RequestBody CreateTransactionRequest request) {

        TransactionResponse transaction = transactionService.createTransaction(request);

        return ApiResponse.success(
                "Transaction created successfully",
                transaction
        );
    }
}