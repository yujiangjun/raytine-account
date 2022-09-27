package com.yujiangjun.account.exception;

import com.yujiangjun.account.constants.ExceptionEnum;

public class LoginException extends RuntimeException{

    private final ExceptionEnum exceptionEnum;


    public LoginException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }
}
