package com.qzp.demo.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Auther: qzp
 * @Date: 2022/8/11 10:24
 * @Description:监听器
 * 1.新建类MyListener实现ServletContextListener
 * 2.3.在springboot的启动类中添加@ServletComponentScan
 */
@Slf4j
@WebListener  //表示该类是一个监听器
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      log.info("初始化监听器");
      log.info(sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("销毁监听器");
    }
}
