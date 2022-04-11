package com.br.letscode.databaseproject.account.dto.request;

import com.br.letscode.databaseproject.account.model.Account;
import com.br.letscode.databaseproject.account.model.AccountType;
import com.br.letscode.databaseproject.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class AccountCreateRequest {
    @NotNull  @Positive
    private Integer number;

    @NotNull @Positive
    private Integer agency;

    @NotNull
    private AccountType accountType;

    @NotNull @PositiveOrZero
    private BigDecimal balance;

    @NotNull @PositiveOrZero
    private Integer userId;

    public Account toAccount(User user){
        var account = new Account();
        BeanUtils.copyProperties(this, account);
        account.setUser(user);
        return account;
    }
}
