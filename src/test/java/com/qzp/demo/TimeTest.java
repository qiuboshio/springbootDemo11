package com.qzp.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: qzp
 * @Date: 2022/8/17 09:11
 * @Description:
 */
public class TimeTest {
    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        System.out.println(date);
    }
}
