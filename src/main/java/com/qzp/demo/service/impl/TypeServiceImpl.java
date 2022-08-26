package com.qzp.demo.service.impl;

import com.qzp.demo.entity.TType;
import com.qzp.demo.mapper.TypeDao;
import com.qzp.demo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: qzp
 * @Date: 2022/8/12 14:19
 * @Description:操作blog数据库中的type表-服务层实现类
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeDao typeDao;
    @Override
    public int find(TType type) {
        return typeDao.insert(type);
    }

    @Override
    public List<TType> selectType(Long id) {
        System.out.println(typeDao.selectType(id));
        return typeDao.selectType(id);
    }
    //修改方法
    @Override
    public Boolean updateType(TType type) {
        return typeDao.updateType(type);
    }

    @Override
    public int insert(TType type1) {
        return typeDao.insert(type1);
    }
}
