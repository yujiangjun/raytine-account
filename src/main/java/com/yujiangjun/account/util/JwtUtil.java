package com.yujiangjun.account.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JwtUtil {

    public static String getToken(String audience,String encryptPass){
        return JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis()+7*24*60*60*1000))  //设置过期时间
                .withAudience(audience) //设置接受方信息，一般时登录用户
                .sign(Algorithm.HMAC256(encryptPass));
    }

    public static String verify(String token,String encryptPass) throws com.auth0.jwt.exceptions.JWTVerificationException{
        String userId = JWT.decode(token).getAudience().get(0);
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(encryptPass)).build();
        jwtVerifier.verify(token);
        return userId;
    }
}
