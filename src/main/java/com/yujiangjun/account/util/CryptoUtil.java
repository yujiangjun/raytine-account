package com.yujiangjun.account.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

public class CryptoUtil {
    private static final RSA rsa = new RSA();
    private CryptoUtil(){}

    public static byte[] encrypt(String text){
        return rsa.encrypt(text, CharsetUtil.CHARSET_UTF_8,KeyType.PublicKey);
    }

    public static byte[] decrypt(byte[] encrypt){
        return rsa.decrypt(encrypt,KeyType.PrivateKey);
    }
}
