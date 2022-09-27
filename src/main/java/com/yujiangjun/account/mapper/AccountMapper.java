package com.yujiangjun.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yujiangjun.account.model.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}