package com.qzp.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qzp.demo.entity.TTest;

/**
 * @Auther: qzp
 * @Date: 2022/8/12 17:50
 * @Description:
 */
public interface TestDao extends BaseMapper<TTest> {
    int update(TTest test);
}
