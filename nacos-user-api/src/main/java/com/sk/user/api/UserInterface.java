package com.sk.user.api;

import com.sk.user.api.dto.PageQueryDTO;
import com.sk.user.api.dto.ResponseData;
import com.sk.user.api.dto.UserDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author shirken
 * @describe
 * @date 2024/2/2 4:09 PM
 */
@Api(tags = { "用户模块" })
public interface UserInterface {

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('user.get')")
    String get(Integer id);

    @RequestMapping(value = "/user/getByName", method = RequestMethod.POST)
    @Secured("ROLE_USER_GETBYNAME")
    String getByName(String name);

    @RequestMapping(value = "/user/getList", method = RequestMethod.POST)
    @ApiOperation("获取用户列表")
    ResponseData<Object> getList(@RequestBody UserDO bo);

    @RequestMapping(value = "/user/getPage", method = RequestMethod.POST)
    @ApiOperation("获取用户列表(分页)")
    ResponseData<Object> getPage(@RequestBody PageQueryDTO pageQueryDTO);

    String SERVICE_NAME = "user-provider";
}
