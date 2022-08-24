package com.qzp.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: qzp
 * @Date: 2022/7/22 16:43
 * @Description:
 */
@RestController
@RequestMapping("/testParam")
public class ParamController {
    //PathVariable绑定请求地址的参数
    @RequestMapping("/user/{id}")
    public Map  test(@PathVariable("id") String id,
//                        @RequestParam("age") int age,
                        @RequestParam()Map<String,String> map){
        Map<String,Object> map1 = new HashMap<>();

        map1.put("id",id);
//        map1.put("age",age);
        map1.put("map",map);
        return map1;
    }
}
