package com.qzp.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ServletComponentScan  //在springboot启动类中注册过滤器
@MapperScan("com.qzp.demo.mapper")  //mapper全局包扫面，添加此注解后可以不用在mapper接口类中添加mapper注解
public class DemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
        //2、查看容器里面的组件
//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }

    }


}
