package com.qzp.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Auther: qzp
 * @Date: 2022/8/16 17:08
 * @Description:实现redis的序列化
 */
@Configuration
public class MyRedisTemplate {
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<String,Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //设置value的序列化方式
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
