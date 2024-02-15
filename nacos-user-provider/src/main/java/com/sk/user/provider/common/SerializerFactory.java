package com.sk.user.provider.common;

/**
 * @Author Hugo.Wwg
 * @Since 2019-04-22
 */
public class SerializerFactory {

    public static Serializer getSerializer() {
        return new KryoSerializer();
    }
}
