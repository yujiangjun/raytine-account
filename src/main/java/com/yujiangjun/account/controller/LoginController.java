package com.yujiangjun.account.controller;

import com.yujiangjun.account.service.AccountService;
import com.yujiangjun.account.vo.AccountLoginVo;
import com.yujiangjun.account.vo.AccountTokenVo;
import com.yujiangjun.account.vo.Resp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController extends BaseController{

    private final AccountService accountService;

    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public Resp<AccountTokenVo> login(@RequestBody AccountLoginVo loginVo){
        return success(accountService.login(loginVo));
    }
}
