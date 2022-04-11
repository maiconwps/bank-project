package com.br.letscode.databaseproject.account.service;

import com.br.letscode.databaseproject.account.model.Account;
import com.br.letscode.databaseproject.account.repository.IAccountRepository;
import com.br.letscode.databaseproject.account.projection.AccountView;
import com.br.letscode.databaseproject.shared.exceptions.ConflictError;
import com.br.letscode.databaseproject.shared.exceptions.MessageError;
import com.br.letscode.databaseproject.account.dto.request.AccountCreateRequest;
import com.br.letscode.databaseproject.account.dto.response.AccountCreateResponse;
import com.br.letscode.databaseproject.shared.exceptions.NotFoundError;
import com.br.letscode.databaseproject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private UserService userService;

    public Page<Account> listAllAccounts(Integer page, Integer size){
        var pageRequest = PageRequest.of(page, size, Sort.Direction.DESC, "number");
        return accountRepository.findAll(pageRequest);
    }

    public Account findAccountById(Integer id) throws NotFoundError {
        return accountRepository.findById(id).orElseThrow(() -> NotFoundError.notExistResourceByIdError("account", id));
    }

    public AccountCreateResponse createAccount(AccountCreateRequest accountCreateRequest) throws NotFoundError, ConflictError {
        var user = userService.findUserById(accountCreateRequest.getUserId());

        if(accountRepository.existAccountWithNumberAndAgency(accountCreateRequest.getNumber(), accountCreateRequest.getAgency())){
            throw new ConflictError(new MessageError("number", "Conta já cadastrada com mesmo número e agência"));
        }

        var account = accountCreateRequest.toAccount(user);
        var accountFull = accountRepository.save(account);
        return AccountCreateResponse.of(accountFull);
    }

    public Page<AccountView> listAllAccountsByUser(Integer userId, Integer page, Integer size) throws NotFoundError {
        var user = userService.findUserById(userId);
        var pageRequest = PageRequest.of(page, size, Sort.Direction.DESC, "number");
        return accountRepository.findAllByUser(user, pageRequest);
    }
}
