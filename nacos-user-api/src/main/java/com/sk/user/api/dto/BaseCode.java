package com.sk.user.api.dto;

/**
 * @Author Hugo.Wwg
 * @Since 2019-04-19
 */
public interface BaseCode {

    int getCode();

    void setCode(int code);

    String getMessage();

    void setMessage(String message);

//    default boolean isSuccess() {
//        return this.getCode() == 0;
//    }
}
