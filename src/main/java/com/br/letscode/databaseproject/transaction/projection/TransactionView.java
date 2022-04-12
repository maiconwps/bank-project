package com.br.letscode.databaseproject.transaction.projection;

import com.br.letscode.databaseproject.account.model.Account;
import com.br.letscode.databaseproject.transaction.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TransactionView {
    public Integer getId();
    public BigDecimal getValue();
    public TransactionType getTransactionType();
    public Integer getNumber();
    public Integer getAgency();
    public LocalDateTime getCreationDate();
}
