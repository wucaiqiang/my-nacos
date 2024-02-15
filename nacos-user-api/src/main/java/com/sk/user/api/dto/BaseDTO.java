package com.sk.user.api.dto;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 基础DTO
 *
 * @author macos
 *
 */
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
