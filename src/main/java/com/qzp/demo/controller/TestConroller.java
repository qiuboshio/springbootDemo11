package com.qzp.demo.controller;

import com.qzp.demo.entity.TTest;
import com.qzp.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.concurrent.*;

/**
 * @Auther: qzp
 * @Date: 2022/8/12 18:01
 * @Description:
 */
@Controller
@Slf4j
public class TestConroller {
    @Autowired
    TestService testService;

    //查询出符合条件的结果列表
    @ResponseBody
    @GetMapping("/findTest/{id}")
    //localhost:8080/findTest/2
    public List<TTest> findTest(@PathVariable("id")Long id){
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        for(int i=0;i<500;i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    List<TTest> list = testService.findList(id);
                }
            });
        }
        System.out.println("值==="+testService.findList(id));
        return testService.findList(id);
    }
    //删除数据
    @ResponseBody
    @GetMapping("/deleteTest/{id}")
    //localhost:8080/deleteTest/1
    public String deleteTest(@PathVariable("id")Long id){
        int i = testService.delete(id);
        return "数据删除成功，影响条数为"+i;
    }
    //修改数据 -mybatis方式
    @ResponseBody
    @GetMapping("/updateTest/{id}/{name}/{age}/{email}")
    //localhost:8080/updateTest/2/qzp/13/qzp@baidu.com
    public String updateTest(@PathVariable("id")Long id,@PathVariable("name")String name,
                       @PathVariable("age")int age,@PathVariable("email")String email){
        TTest tTest = new TTest();
        tTest.setAge(age);
        tTest.setEmail(email);
        tTest.setId(id);
        tTest.setName(name);
        int i = testService.update(tTest);
        return "成功修改的数据条数"+i;
    }
    //修改数据 -mybatis-plus方式
    @ResponseBody
    @GetMapping("/updateByIdTest/{id}/{name}/{age}/{email}")
    //localhost:8080/updateByIdTest/2/qzp/13/qzp@baidu.com
    public String updateByIdTest(@PathVariable("id")Long id,@PathVariable("name")String name,
                       @PathVariable("age")int age,@PathVariable("email")String email){
        TTest tTest = new TTest();
        tTest.setAge(age);
        tTest.setEmail(email);
        tTest.setId(id);
        tTest.setName(name);
        int i = testService.updateById(tTest);
        return "成功修改的数据条数"+i;
    }
}
