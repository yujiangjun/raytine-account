package com.yujiangjun.account.config;

import com.yujiangjun.account.interceptor.CustomerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 用户拦截器
        registry.addInterceptor(new CustomerInterceptor())
                // 需要拦截的请求
                .addPathPatterns("/account/**")
                // 需要放行的请求
                .excludePathPatterns("/account/login")
        // 添加swagger-ui的放行路径
//                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**","/doc.html/**")
        ;

    }
}
