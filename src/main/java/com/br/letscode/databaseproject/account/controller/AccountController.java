package com.br.letscode.databaseproject.account.controller;

import com.br.letscode.databaseproject.account.dto.request.AccountCreateRequest;
import com.br.letscode.databaseproject.account.dto.response.AccountCreateResponse;
import com.br.letscode.databaseproject.account.model.Account;
import com.br.letscode.databaseproject.account.service.AccountService;
import com.br.letscode.databaseproject.shared.exceptions.ConflictError;
import com.br.letscode.databaseproject.shared.exceptions.NotFoundError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping()
    public Page<Account> listAllAccounts(@RequestParam(required = false, defaultValue = "0") Integer page,
                                         @RequestParam(required = false, defaultValue = "10") Integer size){
        return accountService.listAllAccounts(page, size);
    }

    @PostMapping()
    public AccountCreateResponse createAccount(@RequestBody @Valid AccountCreateRequest accountCreateRequest) throws ConflictError, NotFoundError {
        return accountService.createAccount(accountCreateRequest);
    }
}
