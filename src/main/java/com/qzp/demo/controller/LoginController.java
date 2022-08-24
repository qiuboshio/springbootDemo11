package com.qzp.demo.controller;

import com.qzp.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Auther: qzp
 * @Date: 2022/8/11 10:41
 * @Description:登录控制器
 */
@Controller
public class LoginController {
    //跳转到登录界面
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    //http://localhost:8080/login?username=123&password=234
    //获取登录参数进行验证
    @GetMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        //把登录用户的信息存入到session中
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        session.setAttribute(username,user);
        return "login";
    }

}
