package com.br.letscode.databaseproject.transaction.dto;

import com.br.letscode.databaseproject.account.model.Account;
import com.br.letscode.databaseproject.transaction.model.Transaction;
import com.br.letscode.databaseproject.transaction.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TransactionCreateRequest {
    @NotNull  @Positive
    private BigDecimal value;

    @NotNull
    private TransactionType transactionType;

    @NotNull @Positive
    private Integer number;

    @NotNull  @Positive
    private Integer agency;

    public Transaction toTransaction(Account account){
        var transaction = new Transaction();
        BeanUtils.copyProperties(this, transaction);
        transaction.setAccount(account);
        return transaction;
    }
}
