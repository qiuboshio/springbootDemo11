package com.qzp.demo.controller;

import com.qzp.demo.annation.MyAnnotation;
import org.springframework.stereotype.Controller;

@Controller
@MyAnnotation
public class AnnationController {
    @MyAnnotation
    public void aa(){

    }
}
