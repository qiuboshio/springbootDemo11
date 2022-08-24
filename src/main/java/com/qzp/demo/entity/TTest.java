package com.qzp.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Auther: qzp
 * @Date: 2022/8/12 17:40
 * @Description:
 */
@Component
@Data
public class  TTest implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
