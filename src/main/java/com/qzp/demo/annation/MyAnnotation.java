package com.qzp.demo.annation;

import java.lang.annotation.*;

//生成一个注解
@Documented
//表示当前注解可以放在哪里
@Target(value = {ElementType.TYPE, ElementType.METHOD})
//指定被修饰的Annotation将具有继承性
@Inherited
//SOURCE注解仅存在于源码中，在class字节码文件中不包含  改为RUNTIME会在class字节码文件中存在
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation {
    String value() default "qzp";
}
