package com.qzp.demo.controller;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.Interceptor;
import org.omg.PortableInterceptor.InterceptorOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Auther: qzp
 * @Date: 2022/7/24 16:23
 * @Description:拦截器测试
 */

@Controller
@Slf4j
public class InterceptorController  {
//    @RequestMapping("/login1/{username}/{password}")
//    public String login(@PathVariable("username")String username,
//                        @PathVariable("password")String password, HttpSession session){
//        String x = username;
//        session.setAttribute("userInfo",username+"=="+password);
//        System.out.println(username+"==="+password);
//        return "login1";
//    }
    @RequestMapping("/login1")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password, HttpSession session){
        session.setAttribute("userInfo",username+"=="+password);
          System.out.println(username+"==="+password);
        return "index1";
    }
    @RequestMapping("/index1")
    public String index(@RequestParam("username")String username,
                        @RequestParam("password")String password, HttpSession session){
        System.out.println("正在进入首页");
        return "index1";
    }
}
