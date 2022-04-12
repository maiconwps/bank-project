package com.br.letscode.databaseproject.transaction.dto;

import com.br.letscode.databaseproject.account.model.Account;
import com.br.letscode.databaseproject.transaction.model.Transaction;
import com.br.letscode.databaseproject.transaction.model.TransactionType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TransactionCreateResponse {
    private Integer id;
    private BigDecimal value;
    private TransactionType transactionType;
    private Integer number;
    private Integer agency;
    private Account account;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public static TransactionCreateResponse of(Transaction transaction){
        var transactionCreateResponse = new TransactionCreateResponse();
        BeanUtils.copyProperties(transaction, transactionCreateResponse);
        return transactionCreateResponse;
    }
}
