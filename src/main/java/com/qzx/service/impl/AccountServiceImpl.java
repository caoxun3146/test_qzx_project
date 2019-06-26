package com.qzx.service.impl;

import com.qzx.dao.model.Account;
import com.qzx.dao.repository.AccountRepository;
import com.qzx.service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findById(Long id) {
        Account account = accountRepository.findById(id).get();
        return account;
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

}
