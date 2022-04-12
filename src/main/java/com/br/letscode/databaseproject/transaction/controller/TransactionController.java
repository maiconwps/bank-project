package com.br.letscode.databaseproject.transaction.controller;

import com.br.letscode.databaseproject.shared.exceptions.NotFoundError;
import com.br.letscode.databaseproject.shared.exceptions.SemanticError;
import com.br.letscode.databaseproject.transaction.dto.TransactionCreateRequest;
import com.br.letscode.databaseproject.transaction.dto.TransactionCreateResponse;
import com.br.letscode.databaseproject.transaction.model.Transaction;
import com.br.letscode.databaseproject.transaction.model.TransactionType;
import com.br.letscode.databaseproject.transaction.projection.TransactionView;
import com.br.letscode.databaseproject.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/accounts/{accountId}/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionCreateResponse createTransaction(@RequestBody @Valid TransactionCreateRequest transactionCreateRequest,
                                                       @PathVariable Integer accountId) throws SemanticError, NotFoundError {
        return transactionService.createTransaction(transactionCreateRequest, accountId);
    }

    @GetMapping()
    public Page<TransactionView> getAllTransactionsByAccountId(@PathVariable Integer accountId,
                                                               @RequestParam(required = false) TransactionType type,
                                                               @RequestParam(required = false, defaultValue = "0") Integer page,
                                                               @RequestParam(required = false, defaultValue = "10") Integer size) throws NotFoundError {
        return transactionService.getAllUserTransactions(accountId, type, page, size);
    }
}
