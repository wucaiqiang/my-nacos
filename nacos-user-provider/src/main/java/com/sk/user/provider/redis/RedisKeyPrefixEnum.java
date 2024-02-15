package com.sk.user.provider.redis;

/**
 * @Author Hugo.Wwg
 * @Since 2019-04-22
 */
public enum RedisKeyPrefixEnum {

    ACCOUNT_KEY("account:", "account 模块 redis key 前缀"),
    USER_KEY("user:", "user 模块 redis key 前缀"),
    ORDER_KEY("order:", "order 模块 redis key 前缀"),
    MESSAGE_KEY("message:", "message 消息模块 redis key 前缀"),
    WALLET_KEY("wallet:", "wallet 模块 redis key 前缀"),
    MARKET_KEY("market:", "market 模块 redis key 前缀"),
    EXCHANGE_MARKET_KEY("exchange_market:", "exchange market 模块 redis key 前缀"),
    MATCH_KEY("match:", "match 模块 redis key 前缀"),
    EXCHANGE_MATCH_KEY("exchange_match:", "exchange match 模块 redis key 前缀"),
    ROBOT_KEY("robot:", "robot 模块 redis key 前缀"),
    OPTION_KEY("option:", "option 模块 redis key 前缀");

    private String keyPrefix;
    private String keyInfo;

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    public String getKeyInfo() {
        return keyInfo;
    }

    public void setKeyInfo(String keyInfo) {
        this.keyInfo = keyInfo;
    }

    RedisKeyPrefixEnum(String keyPrefix, String keyInfo) {
        this.keyPrefix = keyPrefix;
        this.keyInfo = keyInfo;
    }
}
