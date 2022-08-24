package com.qzp.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: qzp
 * @Date: 2022/7/24 16:49
 * @Description:拦截器
 * 1.新建配置类添加@Configuration注解并且实现WebMvcConfigurer
 * 2.新建类MyInterceptor实现类并且实现HandlerInterceptor
 *
 */
@Configuration
public class InterceptorWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")  //所有请求都会被拦截包括静态资源
                .excludePathPatterns("/login/**","static/**","/index/**");//放行login请求


    }
}
