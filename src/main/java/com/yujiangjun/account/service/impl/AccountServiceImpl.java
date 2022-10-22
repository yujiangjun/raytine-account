package com.yujiangjun.account.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yujiangjun.account.components.CurrentUser;
import com.yujiangjun.account.constants.ExceptionEnum;
import com.yujiangjun.account.exception.LoginException;
import com.yujiangjun.account.mapper.AccountMapper;
import com.yujiangjun.account.model.Account;
import com.yujiangjun.account.service.AccountService;
import com.yujiangjun.account.util.JwtUtil;
import com.yujiangjun.account.vo.AccountLoginVo;
import com.yujiangjun.account.vo.AccountTokenVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    private final RedisTemplate<String,Account> redisTemplate;

    private final CurrentUser currentUser;

    @Value("${jwt.encryptPass}")
    private String encryptPass;

    public AccountServiceImpl(RedisTemplate<String, Account> redisTemplate, CurrentUser currentUser) {
        this.redisTemplate = redisTemplate;
        this.currentUser = currentUser;
    }

    @Override
    public AccountTokenVo login(AccountLoginVo loginVo) {
        LambdaQueryWrapper<Account> queryWrapper = new QueryWrapper<Account>().lambda().eq(Account::getUserCode, loginVo.getUserCode());
        if (count(queryWrapper)==0){
            throw new LoginException(ExceptionEnum.ACCOUNT_NOT_EXIST);
        }
        queryWrapper.eq(Account::getPassword, loginVo.getPassword());
        if (count(queryWrapper)==0){
            throw new LoginException(ExceptionEnum.LOGIN_PASS_ERROR);
        }
        queryWrapper.last("limit 1");
        Account account = getOne(queryWrapper);

        String token = JwtUtil.getToken(String.valueOf(account.getId()),encryptPass);
        redisTemplate.boundValueOps(token).set(account,7, TimeUnit.DAYS);
        currentUser.setUser(account);
        AccountTokenVo tokenVo = BeanUtil.copyProperties(account, AccountTokenVo.class);
        tokenVo.setToken(token);
        return tokenVo;
    }
}
