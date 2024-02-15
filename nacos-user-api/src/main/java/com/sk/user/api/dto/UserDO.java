package com.sk.user.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author shirken
 * @describe
 * @date 2024/2/2 4:22 PM
 */
@ApiModel(description = "用户信息")
public class UserDO {
    @ApiModelProperty(value = "用户id", required = false)
    private String id;
    @ApiModelProperty(value = "用户名", required = true)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
