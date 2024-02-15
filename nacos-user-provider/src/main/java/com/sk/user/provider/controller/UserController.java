package com.sk.user.provider.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sk.user.api.UserInterface;
import com.sk.user.api.dto.PageQueryDTO;
import com.sk.user.api.dto.ResponseData;
import com.sk.user.api.dto.UserDO;
import com.sk.user.provider.db.user.entity.UserEntity;
import com.sk.user.provider.db.user.mapper.UserMapper;
import com.sk.user.provider.dto.PageResult;
import com.sk.user.provider.dto.UserInfoDTO;
import com.sk.user.provider.dto.UserQueryDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author shirken
 * @describe
 * @date 2024/2/2 4:35 PM
 */
@Slf4j
@RestController
@RefreshScope
public class UserController implements UserInterface {
    @Value("${address:''}")
    private String address;
    @Value("true")
    private Boolean openAllRequest;//是否开放所有请求
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseData<Object> getList(UserDO bo) {
        log.info("bo={}", JSON.toJSONString(bo));
        UserQueryDTO userQueryDTO=new UserQueryDTO();
        if(null !=bo.getId()){
            userQueryDTO.setUserId(Long.parseLong(bo.getId()));
        }
        if(StringUtils.isNotBlank(bo.getName())){
            userQueryDTO.setNickname(bo.getName());
        }
        List<UserInfoDTO> userInfoDTOS=userMapper.getUserList(userQueryDTO);
        return ResponseData.success(userInfoDTOS);
    }

    @Override
    public String getByName(String name) {
        log.info("name={}", name);
        UserEntity userEntity=userMapper.queryUser(name);
        return userEntity.getPhone();
    }

    @Override
    public String get(Integer id) {
        log.info("id={}",id);
        UserEntity userEntity=userMapper.selectByPrimaryKey(id);
        log.info("name={}",userEntity.getNickname());
        return userEntity.getNickname();
    }

    @Override
    public ResponseData<Object> getPage(PageQueryDTO dto) {
        Example example = new Example(UserEntity.class);
        example.orderBy("id").desc();
        Page<UserEntity> page = PageHelper.startPage(dto.getPageIndex(), dto.getPageSize()).doSelectPage(() -> userMapper.selectByExample(example));
        PageResult pageResult=new PageResult();
        pageResult.setPages(page.getPages());
        pageResult.setTotal(page.getTotal());
        pageResult.setDatas(page.getResult());
        return ResponseData.success(pageResult);
    }
}
