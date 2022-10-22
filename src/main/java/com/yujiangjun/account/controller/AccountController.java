package com.yujiangjun.account.controller;

import com.yujiangjun.account.model.Account;
import com.yujiangjun.account.service.AccountService;
import com.yujiangjun.account.vo.Resp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AccountController extends BaseController{

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getUserInfo")
    public Resp<Account> getUserInfo(Integer id){
        return success(accountService.getById(id));
    }
}
