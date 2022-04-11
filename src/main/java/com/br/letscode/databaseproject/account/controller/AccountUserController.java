package com.br.letscode.databaseproject.account.controller;

import com.br.letscode.databaseproject.account.service.AccountService;
import com.br.letscode.databaseproject.account.projection.AccountView;
import com.br.letscode.databaseproject.shared.exceptions.NotFoundError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userId}/accounts")
public class AccountUserController {
    @Autowired
    private AccountService accountService;

    @GetMapping()
    public Page<AccountView> findAllAccountsByUser(@PathVariable Integer userId,
                                                   @RequestParam(required = false, defaultValue = "0") Integer page,
                                                   @RequestParam(required = false, defaultValue = "10") Integer size) throws NotFoundError {
        return accountService.listAllAccountsByUser(userId, page, size);
    }
}
