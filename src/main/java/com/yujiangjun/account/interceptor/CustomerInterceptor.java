package com.yujiangjun.account.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.yujiangjun.account.components.CurrentUser;
import com.yujiangjun.account.constants.ExceptionEnum;
import com.yujiangjun.account.model.Account;
import com.yujiangjun.account.util.JwtUtil;
import com.yujiangjun.account.util.SpringContextUtil;
import com.yujiangjun.account.vo.Resp;
import com.yujiangjun.account.vo.RespFactory;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
@Slf4j
public class CustomerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
     RedisTemplate<String, Account> redisTemplate = SpringContextUtil.getBean(RedisTemplate.class,"redisTemplate");
        String token = request.getHeader("token");

        Resp<Void> resp;
        // 捕获刚刚JWT中抛出的异常,并封装对应的返回信息
        try {
            log.info("token:{}",token);
            String userId = JwtUtil.verify(token,"account");
            if (userId !=null){
                Account account = redisTemplate.boundValueOps(token).get();
                log.info("account:{}",account);
                if (CurrentUser.getUser()==null) {
                    CurrentUser.setUser(account);
                }
                return true;
            }
            resp = RespFactory.createVoidResp(ExceptionEnum.TOKEN_EXPIRED.getCode(), ExceptionEnum.TOKEN_EXPIRED.getMessage());
        }catch (SignatureVerificationException e){
            resp = RespFactory.createVoidResp(ExceptionEnum.INVALID_SIGNATURE.getCode(), ExceptionEnum.INVALID_SIGNATURE.getMessage());
        }catch (TokenExpiredException e){
            resp = RespFactory.createVoidResp(ExceptionEnum.TOKEN_EXPIRED.getCode(), ExceptionEnum.TOKEN_EXPIRED.getMessage());
        }catch (AlgorithmMismatchException e){
            resp = RespFactory.createVoidResp(ExceptionEnum.ALGORITHM_INCONSISTENCY.getCode(), ExceptionEnum.ALGORITHM_INCONSISTENCY.getMessage());
        }catch (Exception e){
            resp = RespFactory.createVoidResp(ExceptionEnum.IDENTITY_INFORMATION_IS_INVALID.getCode(), ExceptionEnum.IDENTITY_INFORMATION_IS_INVALID.getMessage());
        }
        CurrentUser.unload();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(resp);
        writer.flush();
        writer.close();
        return false;
    }
}
