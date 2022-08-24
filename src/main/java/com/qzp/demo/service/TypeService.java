package com.qzp.demo.service;

import com.qzp.demo.entity.TType;

import java.util.List;

/**
 * @Auther: qzp
 * @Date: 2022/8/12 14:18
 * @Description:操作blog数据库中的type表-服务层
 */

public interface TypeService {
    //插入方法
    int insert(TType type);
    //查询方法
    List<TType> selectType(Long id);
    //修改方法
    Boolean updateType(TType type);
}
