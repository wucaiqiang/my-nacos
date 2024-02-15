package com.sk.order.controller;

import com.sk.user.api.dto.ResponseData;
import com.sk.user.api.dto.UserDO;
import com.sk.user.rpc.UserRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shirken
 * @describe
 * @date 2024/2/2 4:35 PM
 */
@RestController
@RefreshScope
public class OrderController {
    @Autowired
    private UserRpc userRpc;

    @GetMapping("/order/get")
    public Object get() {
        String ttt=userRpc.get(102933);
        return "order="+ttt;
    }

    @GetMapping("/order/getList")
    public Object getList() {
        UserDO userDO=new UserDO();
        userDO.setName("sk");
        ResponseData<Object> result = userRpc.getList(userDO);
        return result;
    }
}
