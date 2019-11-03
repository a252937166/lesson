package com.ouyang.lesson.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @author Ouyang
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();

        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
        //使用fastJson序列化
        GenericFastJsonRedisSerializer jsonRedisSerializer = new GenericFastJsonRedisSerializer();
        template.setConnectionFactory(factory);
        //key序列化方式
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        //value序列化
        template.setValueSerializer(jsonRedisSerializer);
        //value hashmap序列化
        template.setHashValueSerializer(jsonRedisSerializer);
        return template;
    }

    /**
     * 默认保存30秒
     * @param factory RedisConnectionFactory
     * @return CacheManager
     */
    @Bean
    @Primary
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
        //使用fastjson序列化
        GenericFastJsonRedisSerializer jsonRedisSerializer = new GenericFastJsonRedisSerializer();
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofDays(1))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringRedisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jsonRedisSerializer))
                .disableCachingNullValues();
        return RedisCacheManager.builder(factory)
                .cacheDefaults(config)
                .build();
    }

    /**
     * 保存一个月
     * @param factory RedisConnectionFactory
     * @return CacheManager
     */
    @Bean("seconds")
    public CacheManager cacheManagerForMonth(RedisConnectionFactory factory) {
        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
        //使用fastjson序列化
        GenericFastJsonRedisSerializer jsonRedisSerializer = new GenericFastJsonRedisSerializer();
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(5))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringRedisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jsonRedisSerializer))
                .disableCachingNullValues();
        return RedisCacheManager.builder(factory)
                .cacheDefaults(config)
                .build();
    }

}