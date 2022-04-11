package com.br.letscode.databaseproject.account.repository;

import com.br.letscode.databaseproject.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
}
