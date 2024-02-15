package com.sk.user.provider.exception;


import com.sk.user.api.dto.BaseCode;

/**
 * 应用错误
 *
 * @Author Hugo.Wwg
 * @Since 2019-04-19
 */
public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    /**
     * 错误代码
     */
    private BaseCode baseCode;

    /**
     * 构造函数
     */
    public AppException() {
    }

    /**
     * 构造函数
     *
     * @param baseCode 应用代码
     */
    public AppException(BaseCode baseCode) {
        super(baseCode.getMessage());
        this.baseCode = baseCode;
    }

    /**
     * 构造函数
     *
     * @param baseCode 应用代码
     * @param msgArgs  格式化消息参数，请参考{@linkplain String String.format}
     */
    public AppException(BaseCode baseCode, Object... msgArgs) {
        super(String.format(baseCode.getMessage(), msgArgs));
        this.baseCode = baseCode;
    }

    /**
     * 构造函数
     *
     * @param code    错误代码
     * @param message 错误描述
     */
    public AppException(int code, String message) {
        this(code, message, null);
    }


    public AppException(String message) {
        super(message);
    }


    /**
     * 构造函数
     *
     * @param code    错误代码
     * @param message 错误描述
     * @param cause   错误对象
     */
    public AppException(int code, String message, Throwable cause) {
        super(message, cause);
        this.baseCode = new DefaultBaseCode(code, message);
    }

    public BaseCode getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(BaseCode baseCode) {
        this.baseCode = baseCode;
    }

    class DefaultBaseCode implements BaseCode {
        private int code;
        private String message;

        public DefaultBaseCode(int code, String message) {
            this.setCode(code);
            this.setMessage(message);
        }

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public void setCode(int code) {
            this.code = code;
        }

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public void setMessage(String message) {
            this.message = message;
        }
    }

}
