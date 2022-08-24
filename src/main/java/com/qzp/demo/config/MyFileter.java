package com.qzp.demo.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @Auther: qzp
 * @Date: 2022/8/11 09:32
 * @Description: 实现过滤器功能
 * 1.实现Filter类
 * 2.传递过滤器链filterChain
 * 3.在springboot的启动类中添加@ServletComponentScan
 */
@WebFilter(urlPatterns = "/testParam/*")   //将要过滤的请求
@Slf4j
public class MyFileter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("开始执行过滤器");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
