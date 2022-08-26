package com.qzp.demo.annation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//生成一个注解
@Documented
//表示当前注解可以放在哪里
@Target(value = {ElementType.TYPE, ElementType.METHOD})
public @interface AnnationDemo {
}
