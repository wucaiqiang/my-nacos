package com.sk.user.provider.common;

/**
 * @Author Hugo.Wwg
 * @Since 2019-04-22
 */
public interface Serializer {

    byte[] encode(Object msg);

    <T> byte[] encode(Object msg, Class<T> type);

    <T> T decode(byte[] buf, Class<T> type);

}
