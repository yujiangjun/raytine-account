package com.yujiangjun.account.controller;

import com.yujiangjun.account.vo.Resp;
import com.yujiangjun.account.vo.RespFactory;

import static com.yujiangjun.account.constants.CoreConstant.*;

public class BaseController {

    public static <T> Resp<T> success(T data){
        return RespFactory.createResp(SUCCESS_CODE,SUCCESS_MSG,data);
    }

    public static Resp<Void> fail(){
        return RespFactory.createVoidResp(FAIL_CODE,FAIL_MSG);
    }

    public static <T> Resp<T> customer(int code,String mes,T data){
        return RespFactory.createResp(code,mes,data);
    }
}
