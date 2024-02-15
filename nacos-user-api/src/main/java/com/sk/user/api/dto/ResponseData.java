package com.sk.user.api.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author Hugo.Wwg
 * @Since 2019-04-18
 */

public class ResponseData<T> {
    private static Logger logger = LoggerFactory.getLogger(ResponseData.class);
    private int code;
    private String message;
    private T data;

    private ResponseData() {
        this.code = ResponseCode.SUCCESS.getCode();
        try {
            this.message = "成功";
        } catch (Exception e) {
            this.message = "system busy";
        }
    }

    //成功返回
    public static ResponseData success() {
        return success(null);
    }

    public static <T> ResponseData<T> success(T data) {
        ResponseData responseData = new ResponseData();
        responseData.setData(data);
        return responseData;
    }

    public static ResponseData success(int code, String message) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(code);
        responseData.setMessage(message);
        return responseData;
    }

    public static <T> ResponseData<T> success(int code, String message, T data) {
        ResponseData responseData = new ResponseData();
        responseData.setData(data);
        responseData.setCode(code);
        responseData.setMessage(message);
        return responseData;
    }

    //格式化message，成功返回
    public static ResponseData success(int code, String message, String... properties) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(code);
        responseData.setMessage(message);
        return responseData;
    }

    //失败返回
    public static ResponseData failure(int code, String message) {
        ResponseData responseData = buildMessage(code, message);
        return responseData;
    }

    public static <T> ResponseData<T> failure(
            int code, String message, T data) {
        ResponseData responseData = buildMessage(code, message);
        responseData.setData(data);
        return responseData;
    }

    private static ResponseData buildMessage(int code, String message) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(code);
        responseData.setMessage(message);

        return responseData;
    }

    public static ResponseData failure(BaseCode baseCode) {
        return failure(baseCode, null);
    }

    public static <T> ResponseData<T> failure(BaseCode baseCode, T data) {
        ResponseData responseData = new ResponseData();
        String message = null;
        responseData.setCode(baseCode.getCode());
        responseData.setMessage(message);
        responseData.setData(data);
        return responseData;
    }


    //格式化message，失败返回
    public static ResponseData failure(int code, String message, String... properties) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(code);
        responseData.setMessage(message);
        return responseData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getData() {
        return data;
    }

    public ResponseData setData(T data) {
        this.data = data;
        return this;
    }


    public void responseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void ok() {
        this.code = ResponseCode.SUCCESS.getCode();
        this.message = ResponseCode.SUCCESS.getMessage();
    }

    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }


}
