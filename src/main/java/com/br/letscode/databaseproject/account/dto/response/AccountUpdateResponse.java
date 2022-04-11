package com.br.letscode.databaseproject.account.dto.response;

import com.br.letscode.databaseproject.account.model.Account;
import com.br.letscode.databaseproject.account.model.AccountType;
import com.br.letscode.databaseproject.user.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AccountUpdateResponse {
    private Integer id;
    private Integer number;
    private Integer agency;
    private AccountType accountType;
    private BigDecimal balance;
    private User user;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public static AccountUpdateResponse of (Account account){
        var accountUpdateResponse = new AccountUpdateResponse();
        BeanUtils.copyProperties(account, accountUpdateResponse);
        return accountUpdateResponse;
    }
}
