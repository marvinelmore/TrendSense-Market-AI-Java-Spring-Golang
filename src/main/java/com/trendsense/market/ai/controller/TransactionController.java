package com.trendsense.market.ai.controller;

import com.trendsense.market.ai.dto.ApiResponse;
import com.trendsense.market.ai.dto.CreateTransactionRequest;
import com.trendsense.market.ai.dto.TransactionResponse;
import com.trendsense.market.ai.service.TransactionService;
import com.trendsense.market.ai.dto.UpdateTransactionRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/holding/{holdingId}")
    public ApiResponse<List<TransactionResponse>> getTransactionsByHoldingId(
            @PathVariable Long holdingId) {

        List<TransactionResponse> transactions =
                transactionService.getTransactionsByHoldingId(holdingId);

        return ApiResponse.success(
                "Transactions retrieved successfully",
                transactions
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<TransactionResponse> getTransactionById(
            @PathVariable Long id) {

        TransactionResponse transaction =
                transactionService.getTransactionById(id);

        return ApiResponse.success(
                "Transaction retrieved successfully",
                transaction
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<TransactionResponse> updateTransaction(
            @PathVariable Long id,
            @RequestBody UpdateTransactionRequest request
    ) {
        TransactionResponse transaction =
                transactionService.updateTransaction(id, request);

        return ApiResponse.success(
                "Transaction updated successfully",
                transaction
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteTransaction(
            @PathVariable Long id
    ) {
        transactionService.deleteTransaction(id);

        return ApiResponse.success(
                "Transaction deleted successfully",
                "Transaction with id " + id + " was deleted"
        );
    }

}