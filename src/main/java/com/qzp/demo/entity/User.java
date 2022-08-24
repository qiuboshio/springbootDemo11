package com.qzp.demo.entity;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: qzp
 * @Date: 2022/7/20 17:07
 * @Description:
 */
@ConfigurationProperties(prefix = "user")  //匹配配置文件前缀user，并且属性和本实体类的属性相匹配
@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String userName;
    private String password;

}
