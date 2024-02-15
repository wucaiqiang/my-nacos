package com.sk.user.provider.db.user.mapper;

import com.sk.user.provider.db.base.MyMapper;
import com.sk.user.provider.db.user.entity.UserEntity;
import com.sk.user.provider.dto.UserInfoDTO;
import com.sk.user.provider.dto.UserQueryDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends MyMapper<UserEntity> {

    List<UserInfoDTO> getUserList(UserQueryDTO dto);

    @Select("select * from tb_user where nickname = #{nickname}")
    UserEntity queryUser(@Param("nickname") String nickname);

}
