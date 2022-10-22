package com.yujiangjun.account.components;

import com.yujiangjun.account.model.Account;

public class CurrentUser {
    private final static  ThreadLocal<Account> local = new ThreadLocal<>();
    /**
     * 设置用户信息
     *
     * @param user
     */
    public static  void setUser( Account user ){
        local.set( user );
    }

    /**
     * 获取登录用户信息
     *
     * @return
     */
    public static   Account getUser() {
        System.out.println( "当前线程：" + Thread.currentThread().getName() );
        return local.get();
    }


    public static void unload() {
        local.remove(); // Compliant
    }
}
