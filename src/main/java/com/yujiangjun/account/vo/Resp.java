package com.yujiangjun.account.vo;

import lombok.Data;

@Data
public class Resp<T> {

    private int code;
    private String message;
    private T data;
}
