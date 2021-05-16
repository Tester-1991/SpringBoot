package com.shiyan.springboot.controller;

import com.shiyan.springboot.bean.Account;
import com.shiyan.springboot.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AccountService accountService;

    @ResponseBody
    @GetMapping("/acct")
    public Account getAccById(@RequestParam("id") long id) {
        return accountService.getAcctById(id);
    }


    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return String.valueOf(aLong);
    }
}
