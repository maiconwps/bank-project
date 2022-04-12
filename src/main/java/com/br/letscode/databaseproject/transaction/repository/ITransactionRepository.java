package com.br.letscode.databaseproject.transaction.repository;

import com.br.letscode.databaseproject.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
}
