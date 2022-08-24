package com.qzp.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: qzp
 * @Date: 2022/8/11 10:02
 * @Description:拦截器的实现类
 */
@Slf4j
public class MyInterceptor implements HandlerInterceptor {
    //在servlet处理器执行之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("开始执行拦截器");
        Object user = request.getSession().getAttribute("123");
        log.info("当前用户"+user);
        if (user==null){
            log.info("用户未登录");
            response.sendRedirect("/index");
            return false;
        }else{
            log.info("用户已登录");
            return true;
        }

    }
    //在servlet处理器执行后，返回ModelAndView之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //在servlet处理器执行之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
