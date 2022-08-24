package com.qzp.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * @Auther: qzp
 * @Date: 2022/8/11 12:08
 * @Description:配置自动启动类，系统启动成功后自动打开浏览器
 */
@Component
@Slf4j
public class MyCommandRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyCommandRunner.class);

    //从配置文件中取值
    @Value("${spring.web.loginurl}")
    private String loginUrl;
    @Value("${spring.web.googleexcute}")
    private String googleExcutePath;
    @Value("${spring.auto.openurl}")
    private boolean isOpen;

    @Override
    public void run(String... args) throws Exception {

        //判断是否启动浏览器
        if(isOpen){
            String cmd = googleExcutePath +" "+ loginUrl;
            Runtime run = Runtime.getRuntime();
            try{
                run.exec(cmd);
                logger.debug("启动浏览器打开项目成功");
            }catch (Exception e){
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        }
    }

}
