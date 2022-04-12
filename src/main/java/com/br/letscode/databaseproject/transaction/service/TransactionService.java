package com.br.letscode.databaseproject.transaction.service;

import com.br.letscode.databaseproject.account.model.Account;
import com.br.letscode.databaseproject.account.repository.IAccountRepository;
import com.br.letscode.databaseproject.account.service.AccountService;
import com.br.letscode.databaseproject.shared.exceptions.NotFoundError;
import com.br.letscode.databaseproject.shared.exceptions.SemanticError;
import com.br.letscode.databaseproject.transaction.dto.TransactionCreateRequest;
import com.br.letscode.databaseproject.transaction.dto.TransactionCreateResponse;
import com.br.letscode.databaseproject.transaction.model.Transaction;
import com.br.letscode.databaseproject.transaction.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private ITransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private IAccountRepository accountRepository;

    public TransactionCreateResponse createTransaction(TransactionCreateRequest transactionCreateRequest, Integer accountId) throws NotFoundError, SemanticError {
        var account = accountService.findAccountById(accountId);
        var transaction = transactionCreateRequest.toTransaction(account);

        switch (transaction.getTransactionType()){
            case SAQUE:
                account.withdraw(transaction.getValue());
                break;
            case DEPOSITO:
                account.deposit(transaction.getValue());
                break;
        }
        accountRepository.save(account);
        var transactionFull = transactionRepository.save(transaction);
        return TransactionCreateResponse.of(transaction);
    }
}
