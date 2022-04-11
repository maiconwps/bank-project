package com.br.letscode.databaseproject.account.projection;

import com.br.letscode.databaseproject.account.model.AccountType;
import com.br.letscode.databaseproject.user.projection.UserAccountView;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface AccountUserView {
    Integer getId();
    Integer getNumber();
    Integer getAgency();
    AccountType getAccountType();
    BigDecimal getBalance();
    UserAccountView getUser();
    LocalDateTime getCreationDate();
    LocalDateTime getUpdateDate();
}
