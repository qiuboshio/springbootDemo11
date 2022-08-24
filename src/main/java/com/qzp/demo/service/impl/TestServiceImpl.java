package com.qzp.demo.service.impl;

import com.qzp.demo.entity.TTest;
import com.qzp.demo.mapper.TestDao;
import com.qzp.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: qzp
 * @Date: 2022/8/12 17:53
 * @Description:
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {
    @Autowired
    TestDao testDao;
    @Autowired
    RedisTemplate redisTemplate;
    //查询数据
    @Override
    public List<TTest> findList(Long id) {
        List list = new ArrayList();
        list.add(id);
        //redisTemplate.opsForValue().set(id,testDao.selectBatchIds(list));
        Object listTest = redisTemplate.opsForValue().get(id+"");
        //如果redis缓存中不存在需要的数据，查找数据库
        if (listTest == null) {
            synchronized (this.getClass()) {
                Object listTest1 = redisTemplate.opsForValue().get(id + "");
                if (listTest1 == null) {
                    log.info("查询数据库》》》》》》");
                    //把从数据库查出的数据存入redis中
                    redisTemplate.opsForValue().set(id + "", testDao.selectBatchIds(list));
                    //返回redis中的数据
                    listTest = redisTemplate.opsForValue().get(id + "");
                }else {
                    //读取缓存中数据
                    log.info("读取缓存中的数据（同步代码）》》》》》");
                }
            }
            }else{
                    log.info("读取缓存中的数据》》》》》");
        }
        return (List<TTest>) listTest;
    }
    //修改数据 mybatis-plus方式
    @Override
    public int updateById(TTest test) {
        testDao.updateById(test);
        return testDao.updateById(test);
    }

    //删除数据
    @Override
    public int delete(Long id) {
        int i = testDao.deleteById(id);
        return i;
    }
    //修改数据 mybatis方式
    @Override
    public int update(TTest test) {
        int update = testDao.update(test);
        System.out.println("受影响的条数"+update);
        return update;
    }
}
