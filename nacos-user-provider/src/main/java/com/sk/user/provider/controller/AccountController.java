package com.sk.user.provider.controller;

import com.alibaba.fastjson.JSON;
import com.sk.user.api.AccountInterface;
import com.sk.user.provider.db.account.entity.TimeConfigEntity;
import com.sk.user.provider.db.account.mapper.TimeConfigMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shirken
 * @describe
 * @date 2024/2/5 5:01 PM
 */
@Slf4j
@RestController
public class AccountController implements AccountInterface {
    @Autowired
    private TimeConfigMapper timeConfigMapper;

    @Override
    public String get(Integer id) {
        log.info("id={}", id);
        String key = "user:" + id;
        TimeConfigEntity timeConfigEntity = timeConfigMapper.selectByPrimaryKey(id);
        log.info("timeConfigEntity={}", JSON.toJSONString(timeConfigEntity));
        return timeConfigEntity.getMarket();
    }
}
