package com.shf.mapper;

import com.shf.domain.Account;

import java.util.List;

public interface AccountMapper {
    public void save(Account account);

    public List<Account> findAll();
}
