package com.sk.user.api;

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
public interface AccountInterface {

    @RequestMapping(value = "/account/get", method = RequestMethod.POST)
    String get(Integer id);

    String SERVICE_NAME = "user-provider";
}
