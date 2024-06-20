package com.saurabh.ecommerce.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheClearService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Schedule the task to run every 24 hours (86400000 milliseconds)
    //@Scheduled(fixedRate = 10000) // Adjust the interval as needed  for 10 second


    //    @Scheduled(fixedRate = 10000)
    public void clearAllCache() {
        System.out.println("Clearing all Redis cache keys");
        redisTemplate.getConnectionFactory().getConnection().flushDb();
    }
}