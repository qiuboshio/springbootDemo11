package com.qzp.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sound.midi.SoundbankResource;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_type", Long.class);
        System.out.println("数据库条数"+aLong);
    }

}
