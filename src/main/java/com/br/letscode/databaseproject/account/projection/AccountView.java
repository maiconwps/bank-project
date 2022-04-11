package com.br.letscode.databaseproject.account.projection;

import com.br.letscode.databaseproject.account.model.AccountType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface AccountView {
    Integer getId();
    Integer getNumber();
    Integer getAgency();
    AccountType getAccountType();
    BigDecimal getBalance();
    LocalDateTime getCreationDate();
    LocalDateTime getUpdateDate();
}
