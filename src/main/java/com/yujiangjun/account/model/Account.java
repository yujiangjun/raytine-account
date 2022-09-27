package com.yujiangjun.account.model;

import java.io.Serializable;
import lombok.Data;

/**
    * 用户表
    */
@Data
public class Account implements Serializable {
    private Integer id;

    private String userName;

    private String password;

    private Integer sex;

    private Integer age;

    private String avatar;

    private String userCode;

    private static final long serialVersionUID = 1L;
}