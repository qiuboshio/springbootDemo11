package com.qzp.demo.service;

import com.qzp.demo.entity.TTest;
import org.aspectj.weaver.ast.Test;

import java.util.List;

/**
 * @Auther: qzp
 * @Date: 2022/8/12 17:52
 * @Description:
 */

public interface TestService {
    //查询符合条件的数据
    List<TTest> findList(Long id);
    //删除数据
    int delete(Long id);
    //修改数据， 使用mybatis
    int update(TTest test);
    //修改数据，使用mybatis-plus
    int updateById(TTest test);
}
