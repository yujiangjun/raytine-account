package com.yujiangjun.account.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptoUtilTest {

    @Test
    void encrypt() {
        byte[] encrypt = CryptoUtil.encrypt("hello");
        assertEquals("hello",StrUtil.str(CryptoUtil.decrypt(encrypt),CharsetUtil.CHARSET_UTF_8));
    }

    @Test
    public void encrypt2(){
        String encrypt = StrUtil.str(CryptoUtil.encrypt("123456"), CharsetUtil.CHARSET_UTF_8);
        System.out.println(encrypt);
    }
    @Test
    public void m1() {
        RSA rsa = new RSA();

        rsa.getPrivateKey();
        rsa.getPrivateKeyBase64();
        rsa.getPublicKey();
        rsa.getPublicKeyBase64();

        byte[] encrypt = rsa.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
        byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);

        assertEquals("我是一段测试aaaa", StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8));
    }
}