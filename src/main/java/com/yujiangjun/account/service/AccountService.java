package com.yujiangjun.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yujiangjun.account.model.Account;
import com.yujiangjun.account.vo.AccountLoginVo;

public interface AccountService extends IService<Account> {

    String login(AccountLoginVo loginVo);
}
