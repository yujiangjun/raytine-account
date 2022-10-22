package com.yujiangjun.account.vo;

import com.yujiangjun.account.model.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AccountTokenVo extends Account {
    private String token;
}
