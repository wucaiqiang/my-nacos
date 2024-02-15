package com.sk.user.api;

import com.sk.user.api.dto.KeyValuDO;
import com.sk.user.api.dto.ResponseData;
import com.sk.user.api.dto.UserDO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author shirken
 * @describe
 * @date 2024/2/2 4:09 PM
 */
public interface RedisInterface {

    @RequestMapping(value = "/redis/get", method = RequestMethod.POST)
    Object get(String key);

    @RequestMapping(value = "/redis/set", method = RequestMethod.POST)
    String set(@RequestBody KeyValuDO keyValuDO);

    @RequestMapping(value = "/redis/delete", method = RequestMethod.POST)
    String delete(String key);

    String SERVICE_NAME = "user-provider";
}
