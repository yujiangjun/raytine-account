package com.yujiangjun.account.exception;

import com.yujiangjun.account.vo.Resp;
import com.yujiangjun.account.vo.RespFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoginException.class)
    public Resp<Void> loginFail(LoginException e){
        return RespFactory.createVoidResp(e.getExceptionEnum().getCode(),e.getMessage());
    }
}
