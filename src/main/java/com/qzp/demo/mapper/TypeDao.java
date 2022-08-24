package com.qzp.demo.mapper;

import com.qzp.demo.entity.TType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: qzp
 * @Date: 2022/8/12 15:43
 * @Description:
 */
   //添加mapper注解后mapper.xml文件就能扫描到
public interface TypeDao {
    //插入方法
    int insert(TType type);
    //查询方法 简单的功能可以用注解方式实现
    @Select("select * from t_type where id=#{id}")
    List<TType> selectType(Long id);
    //修改方法
    Boolean updateType(TType type);

}
