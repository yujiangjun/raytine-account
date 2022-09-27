package com.yujiangjun.account.components;

import com.yujiangjun.account.model.Account;
import org.springframework.stereotype.Component;

@Component
public class CurrentUser {
    private final   ThreadLocal<Account> local = new ThreadLocal<>();

    /**
     * 设置用户信息
     *
     * @param user
     */
    public  void setUser( Account user ){
        local.set( user );
    }

    /**
     * 获取登录用户信息
     *
     * @return
     */
    public  Account getUser() {
        System.out.println( "当前线程：" + Thread.currentThread().getName() );
        return local.get();
    }


    public void unload() {
        local.remove(); // Compliant
    }
}
