package com.example.redisdemo.app;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RedisTestController{

    private final RedisService redisService;

    @PostMapping(value = "/add-redis-key")
    public RedisData addRedisKey(@RequestBody RedisData redisData){
        redisService.addRedisKey(redisData.getKey(), redisData.getValue());
        return redisData;
    }

    @PostMapping(value = "/get-redis-value")
    public RedisData getRedisValue(@RequestBody RedisData redisData){
        String value = redisService.getRedisValue(redisData.getKey());
        redisData.setValue(value);
        return redisData;
    }
}
