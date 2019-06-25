package com.qzx.service.service;

import com.qzx.dao.model.Account;

public interface AccountService {
    Account findById(Long id);
    void deleteById(Long id);
}
