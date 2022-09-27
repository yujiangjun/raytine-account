package com.yujiangjun.account.controller;

import com.yujiangjun.account.vo.AccountLoginVo;
import com.yujiangjun.account.vo.Resp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController extends BaseController{

    @PostMapping("/login")
    public Resp<String> login(AccountLoginVo loginVo){

        return success("");
    }
}
