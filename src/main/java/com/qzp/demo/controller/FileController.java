package com.qzp.demo.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @Auther: qzp
 * @Date: 2022/7/24 18:20
 * @Description:文件上传功能
 */
@Controller
@Slf4j
@Api(value="文件上传接口")
public class FileController {
    @GetMapping("/file")
    public String fileIndex(){
        System.out.println("跳转到文件上传页面");
        return "file";
    }
    @PostMapping("/upload")
    public String fileController(@RequestParam("email")String email,
                                 @RequestParam("username") String username,
                                 @RequestPart("headerImg")MultipartFile multipartFile,
                                 @RequestPart("photos")MultipartFile[] multipartFiles) throws IOException {
        //日志打印上传信息
        log.info("email={},username={},头像大小={},图片数量={}",email,username,multipartFile.getSize(),multipartFiles.length);
        //如果头像不为空，存入头像
        if(!multipartFile.isEmpty()){
            //获取文件名
            String name = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("D:\\study\\filetest\\" + name));
        }
        //如果生活照不为空，也存入
        if(multipartFiles.length>0){
            for (MultipartFile photo:multipartFiles
                 ) {
                String name = photo.getOriginalFilename();
                photo.transferTo(new File("D:\\study\\filetest\\" + name));
            }
        }
        return "success";
    }
}
