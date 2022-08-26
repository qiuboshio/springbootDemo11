package com.qzp.demo.controller;

import com.qzp.demo.entity.TType;
import com.qzp.demo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: qzp
 * @Date: 2022/8/12 14:17
 * @Description:操作blog数据库中的type表-控制层
 */
@Controller
public class TypeController {
    @Autowired
    TypeService typeService;
    @Autowired
    TType type;
    //localhost:8080/typeCount/111/qzp
    @ResponseBody
    @GetMapping("/typeCount/{id}/{name}")
    public int typeCount(@PathVariable("id") Long id,@PathVariable("name") String name){
        type.setId(id);
        type.setName(name);
        return typeService.find(type);
    }
    @ResponseBody
    @GetMapping("/find/{id}")
    //localhost:8080/find/1722
    public List<TType> find(@PathVariable("id") Long id){
        return typeService.selectType(id);
    }
    //修改方法
    @ResponseBody
    @GetMapping("/updateType/{id}/{name}")
    //localhost:8080/updateType/1722/齐天大地方
    public Boolean updateType(@PathVariable("id") Long id,
                              @PathVariable("name") String name){
        TType type1 = new TType();
        type1.setId(id);
        type1.setName(name);
        return typeService.updateType(type1);
    }
    //插入方法
    @ResponseBody
    @GetMapping("/insertType/{id}/{name}")
    //localhost:8080/insertType/122/齐大圣
    public int insertType(@PathVariable("id") Long id,
                              @PathVariable("name") String name){
        TType type1 = new TType();
        type1.setId(id);
        type1.setName(name);
        return typeService.insert(type1);
    }
}
