package com.qzx.service.impl;

import com.qzx.dao.model.Account;
import com.qzx.dao.repostiory.AccountRepostiory;
import com.qzx.service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepostiory accountRepostiory;

    @Override
    public Account findById(Long id) {
        Account account = accountRepostiory.findById(id).get();
        return account;
    }

    @Override
    public void deleteById(Long id) {
        accountRepostiory.deleteById(id);
    }

}
