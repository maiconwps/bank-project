package com.br.letscode.databaseproject.transaction.repository;

import com.br.letscode.databaseproject.account.model.Account;
import com.br.letscode.databaseproject.transaction.model.Transaction;
import com.br.letscode.databaseproject.transaction.model.TransactionType;
import com.br.letscode.databaseproject.transaction.projection.TransactionView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
    Page<TransactionView> findAllByAccount(Account account, Pageable pageable);
    Page<TransactionView> findAllByAccountAndTransactionType(Account account, TransactionType transactionType, Pageable pageable);
}
