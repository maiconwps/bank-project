package com.br.letscode.databaseproject.account.controller;

import com.br.letscode.databaseproject.account.model.Account;
import com.br.letscode.databaseproject.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping()
    public Page<Account> listAllAccounts(@RequestParam(required = false) Integer page,
                                         @RequestParam(required = false) Integer size){
        return accountService.listAllAccounts(page, size);
    }
}
