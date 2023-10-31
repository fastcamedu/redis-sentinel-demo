package com.example.redisdemo.app;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    public void addRedisKey(String key, String value){
        try{
            redisTemplate.opsForValue().set(key, value);
        }catch (Exception e){
            log.error(">>> Add redis key error, {}", e.getMessage());
        }
    }

    public String getRedisValue(String key){
        try{
            if(Boolean.TRUE.equals(redisTemplate.hasKey(key))){
                return redisTemplate.opsForValue().get(key);
            }
        }catch (Exception e){
            log.error(">>> Set redis key error, {}", e.getMessage());
        }
        return Strings.EMPTY;
    }
}
