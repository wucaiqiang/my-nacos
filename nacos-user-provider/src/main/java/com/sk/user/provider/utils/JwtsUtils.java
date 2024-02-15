package com.sk.user.provider.utils;

import com.alibaba.fastjson.JSONObject;
import com.sk.user.provider.dto.User;
import com.sk.user.provider.dto.UserInfoDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shirken
 * @describe
 * @date 2024/2/14 5:32 PM
 */
public class JwtsUtils {
    public static final String SECRET = "SECRET_SK";// 密钥
    public static final String USER_KEY = "USER_KEY";
    public static final String USER_SUBJECT = "USER_SUBJECT";// 用户主题
    public static final Long expiration = 3600l;// 过期时间

    public String generateToken(){
        User userInfoDTO=new User();
        userInfoDTO.setUsername("shirken");
        Map<String, Object> claims = new HashMap<>();
        claims.put(USER_KEY, JSONObject.toJSONString(userInfoDTO));
        Date issuedAt = new Date();
        String token = Jwts.builder().setClaims(claims)//
                .setSubject(USER_SUBJECT) // 主题
                .setIssuedAt(issuedAt)// 发行时间
                .setExpiration(new Date(issuedAt.getTime() + expiration * 3 * 1000))// 过期时间
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
        return token;
    }
    public void convertToken(){
        String authToken=this.generateToken();
        System.out.println(authToken);
        Claims mySecret = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(authToken).getBody();
        mySecret.getSubject();
        String userInfo=(String)mySecret.get(USER_KEY);
        System.out.println(userInfo);
    }

    public static void main(String[] args) {
        JwtsUtils jwtsUtils=new JwtsUtils();
        jwtsUtils.convertToken();
    }
}
