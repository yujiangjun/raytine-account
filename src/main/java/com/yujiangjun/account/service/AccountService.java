package com.yujiangjun.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yujiangjun.account.model.Account;
import com.yujiangjun.account.vo.AccountLoginVo;
import com.yujiangjun.account.vo.AccountTokenVo;

public interface AccountService extends IService<Account> {

    AccountTokenVo login(AccountLoginVo loginVo);
}
