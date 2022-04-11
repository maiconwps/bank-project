package com.br.letscode.databaseproject.account.service;

import com.br.letscode.databaseproject.account.model.Account;
import com.br.letscode.databaseproject.account.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private IAccountRepository accountRepository;

    public Page<Account> listAllAccounts(Integer page, Integer size){
        var pageRequest = PageRequest.of(page, size, Sort.Direction.DESC);
        return accountRepository.findAll(pageRequest);
    }
}
