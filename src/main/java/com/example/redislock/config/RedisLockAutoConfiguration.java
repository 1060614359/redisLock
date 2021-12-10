package com.example.redislock.config;

import com.example.redislock.aspect.DistributedRedisLockAspect;
import com.example.redislock.util.DistributedRedisLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author admin
 * @date 2021/12/9 14:21
 */
@Slf4j
@Configuration
public class RedisLockAutoConfiguration {
    @Bean
    public DistributedRedisLock distributedRedisLock(RedisTemplate<Object, Object> redisTemplate){
        log.info("init Distributed Redis Lock");
        return new DistributedRedisLock(redisTemplate);
    }

    @Bean
    public DistributedRedisLockAspect distributedRedisLockAspect(DistributedRedisLock distributedRedisLock){
        log.info("init Distributed Redis Lock Aspect");
        return new DistributedRedisLockAspect(distributedRedisLock);
    }

}
