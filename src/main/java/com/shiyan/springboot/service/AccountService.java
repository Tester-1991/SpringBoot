package com.shiyan.springboot.service;

import com.shiyan.springboot.bean.Account;
import com.shiyan.springboot.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcctById(long id) {
        return accountMapper.getAcct(id);
    }
}
