package com.sk.user.api.dto;

/**
 * @Author Hugo.Wwg
 * @Since 2019-04-18
 */
public enum ResponseCode implements BaseCode {


    SUCCESS(1, "com.hereblock.response.code.success"),
    FAIL(0, "com.hereblock.response.code.fail"),
    INSERT_EXCEPTION(10, "com.hereblock.response.code.insert.exception"),
    UPDATE_EXCEPTION(20, "com.hereblock.response.code.update.exception"),
    DELETE_EXCEPTION(30, "com.hereblock.response.code.delete.exception"),
    SELECT_DATA_EXCEPTION(40, "com.hereblock.response.code.select.data.exception"),
    SELECT_PAGINATION_EXCEPTION(41, "com.hereblock.response.code.select.pagination.exception"),
    USER_NOT_LOGIN(50, "com.hereblock.response.code.user.not.login"),
    ILLEGAL_REQUESTS(400, "com.hereblock.response.code.illegal.requests"),
    RESOURCE_NOT_FOUND(404, "com.hereblock.response.code.resource.not.found"),
    FORBIDDEN(403, "com.hereblock.response.code.forbidden"),
    SYSTEM_EXCEPTION(500, "com.hereblock.response.code.system.exception"),
    AES_KEY_EXPIRED(600, "com.hereblock.response.code.aes.key.expire");


    private int code;
    private String message;

    private ResponseCode(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    @Override
    public String toString() {
        return Integer.toString(getCode());
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }


}
