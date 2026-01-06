package com.db.UrlShortenerApplication.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    
    public String get(String key){
        return Optional.ofNullable(redisTemplate.opsForValue().get(key))
               .map(Object::toString)
               .orElse(null);
    }

    public void set(String key,String val){
        redisTemplate.opsForValue().set(key, val,1,TimeUnit.DAYS);
    } 
}
