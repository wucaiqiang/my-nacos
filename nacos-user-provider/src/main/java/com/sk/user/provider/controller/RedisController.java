package com.sk.user.provider.controller;

import com.sk.user.api.RedisInterface;
import com.sk.user.api.dto.KeyValuDO;
import com.sk.user.provider.config.RedisProperties;
import com.sk.user.provider.redis.RedisKey;
import com.sk.user.provider.redis.RedisKeyPrefixEnum;
import com.sk.user.provider.redis.RedisTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shirken
 * @describe
 * @date 2024/2/5 6:31 PM
 */
@Slf4j
@RestController
public class RedisController implements RedisInterface {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    protected RedisProperties redisProperties;

    @Override
    public Object get(String key) {
        RedisKey redisKey = new RedisKey(RedisKeyPrefixEnum.USER_KEY, key);
        Object ob = redisTemplate.get(redisKey, String.class);
        return ob;
    }

    @Override
    public String set(KeyValuDO keyValuDO) {
        RedisKey redisKey = new RedisKey(RedisKeyPrefixEnum.USER_KEY, keyValuDO.getKey());
        redisTemplate.set(redisKey, keyValuDO.getValue());
        return "ok";
    }

    @Override
    public String delete(String key) {
        RedisKey redisKey = new RedisKey(RedisKeyPrefixEnum.USER_KEY, key);
        redisTemplate.delKey(redisKey);
        return "ok";
    }
}
