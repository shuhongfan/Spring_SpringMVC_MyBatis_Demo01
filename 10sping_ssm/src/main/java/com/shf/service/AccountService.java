package com.shf.service;

import com.shf.domain.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);
    List<Account> findAll();
}
