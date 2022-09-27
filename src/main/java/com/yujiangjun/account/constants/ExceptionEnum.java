package com.yujiangjun.account.constants;

public enum ExceptionEnum implements BaseEnum{
    ACCOUNT_NOT_EXIST(100001,"账户不存在"),
    LOGIN_PASS_ERROR(100002,"账号或密码错误"),
    INVALID_SIGNATURE(100003,"无效签名"),
    TOKEN_EXPIRED(100004,"token过期"),
    ALGORITHM_INCONSISTENCY(100003,"算法不一致"),
    IDENTITY_INFORMATION_IS_INVALID(100003,"身份信息无效"),
    ;

    private final int code;
    private final String message;

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
