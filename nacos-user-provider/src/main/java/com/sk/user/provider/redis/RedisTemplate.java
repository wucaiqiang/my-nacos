package com.sk.user.provider.redis;

import com.sk.user.provider.common.Serializer;
import com.sk.user.provider.common.SerializerFactory;
import com.sk.user.provider.utils.SerializeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.BinaryJedisCluster;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Hugo.Wwg
 * @Since 2019-04-22
 */
@Component
public class RedisTemplate<V> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisTemplate.class);
    @Autowired
    protected BinaryJedisCluster jedisCluster;



    private Serializer serializer = SerializerFactory.getSerializer();

    /**
     * 返回增量 value 后的值
     */
    public Long incr(RedisKey redisKey, long value) {
        return jedisCluster.incrBy(redisKey.getRedisKey().getBytes(), value);
    }

    /**
     * 返回增量 value 后的值
     */
    public Long incrBy(RedisKey redisKey, long value) {
        return jedisCluster.incrBy(redisKey.getRedisKey().getBytes(), value);
    }

    /**
     * 设置永不过期
     *
     * @param redisKey 缓存的key对象
     * @param value    缓存value
     */
    public void set(RedisKey redisKey, Object value) {
        jedisCluster.set(redisKey.getRedisKey().getBytes(), serializer.encode(value));
        LOGGER.debug("RedisUtil:set cache key={},value={}", redisKey.getRedisKey(), value);
    }


    public void set(RedisKey redisKey, Object value, Class clazz) {
        jedisCluster.set(redisKey.getRedisKey().getBytes(), serializer.encode(value, clazz));
        LOGGER.debug("RedisUtil:set cache key={},value={}", redisKey.getRedisKey(), value);
    }

    public Long setnx(RedisKey redisKey, Object value) {
        return jedisCluster.setnx(redisKey.getRedisKey().getBytes(), serializer.encode(value));
    }

    /**
     * 设置缓存，并且由配置文件指定过期时间
     *
     * @param redisKey 缓存的key对象
     */
    public void setWithExpireTime(final RedisKey redisKey, Object value,
                                  RedisKeyExpireTimeEnum redisKeyExpireTimeEnum) {
        jedisCluster.setex(redisKey.getRedisKey().getBytes(),
                redisKeyExpireTimeEnum.getExpireSeconds(), serializer.encode(value));
        LOGGER.debug("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}",
                redisKey.getRedisKey(), value, redisKeyExpireTimeEnum.getExpireSeconds());
    }

    /**
     * 设置缓存，根据毫秒指定过期时间
     *
     * @param redisKey 缓存的key对象
     */
    public void setWithExpireTime(final RedisKey redisKey, Object value, int seconds) {
        jedisCluster.setex(redisKey.getRedisKey().getBytes(), seconds, serializer.encode(value));
        LOGGER.debug("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", redisKey.getRedisKey(), value, seconds);
    }

    /**
     * 设置list缓存，根据毫秒指定过期时间
     */
    public void setListWithExpire(final RedisKey redisKey, List<?> value, int seconds) {
        jedisCluster.setex(redisKey.getRedisKey().getBytes(), seconds, SerializeUtils.encodeList(value));
        LOGGER.debug("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", redisKey.getRedisKey(), value, seconds);
    }

    /**
     * 获取指定key的缓存
     *
     * @param redisKey 缓存的key对象
     * @return Object
     */
    public Object get(final RedisKey redisKey, Class clazz) {
        byte[] bytes = jedisCluster.get(redisKey.getRedisKey().getBytes());
        if (StringUtils.isEmpty(bytes)) {
            return null;
        }
        int length = bytes.length;
        Object value = serializer.decode(bytes, clazz);
        LOGGER.debug("RedisUtil:get cache key={},value={}", redisKey.getRedisKey(), value);
        return value;
    }

    /**
     * 获取list对象
     */
    public List<Object> getList(final RedisKey redisKey) throws Exception {
        byte[] bytes = jedisCluster.get(redisKey.getRedisKey().getBytes());
        if (bytes == null) {
            return null;
        }
        List<Object> value = SerializeUtils.decodeList(bytes);
        LOGGER.debug("RedisUtil:get cache key={},value={}", redisKey.getRedisKey(), value);
        return value;
    }

    public String getString(final RedisKey redisKey) {
        byte[] bytes = jedisCluster.get(redisKey.getRedisKey().getBytes());
        if (StringUtils.isEmpty(bytes)) {
            return null;
        }
        String value = new String(bytes);
        LOGGER.debug("getString from cache key:{}, value:{}", redisKey.getRedisKey(), value);
        return value;
    }

    public void expire(String key, RedisKeyExpireTimeEnum redisKeyExpireTimeEnum) {
        if (null != jedisCluster) {
            jedisCluster.expire(key.getBytes(), redisKeyExpireTimeEnum.getExpireSeconds());
        }
    }

    public void expire(final RedisKey redisKey, int seconds) {
        if (null != jedisCluster) {
            jedisCluster.expire(redisKey.getRedisKey().getBytes(), seconds);
        }
    }

    /**
     * 删除指定key的缓存
     *
     * @param redisKey 缓存的key对象
     */
    public void delKey(final RedisKey redisKey) {
        jedisCluster.del(redisKey.getRedisKey().getBytes());
        LOGGER.debug("RedisUtil:delete cache key={}", redisKey.getRedisKey());
    }

    /**
     * 缓存map对象
     */
    public void hmset(final RedisKey redisKey, Map<byte[], byte[]> map) {
        jedisCluster.hmset(redisKey.getRedisKey().getBytes(), map);
        LOGGER.debug("RedisUtil:hmset cache key={}", redisKey.getRedisKey());
    }


    /**
     * 获取map对象
     */
    public Map<byte[], byte[]> hgetAll(final RedisKey redisKey) {
        Map<byte[], byte[]> map = jedisCluster.hgetAll(redisKey.getRedisKey().getBytes());
        LOGGER.debug("RedisUtil:hmset cache key={}", redisKey.getRedisKey());
        return map;
    }


    /**
     * 校验key是否存在
     */
    public Boolean exists(final RedisKey redisKey) {
        Boolean flag = jedisCluster.exists(redisKey.getRedisKey().getBytes());
        LOGGER.debug("RedisUtil:exists cache key={}", redisKey.getRedisKey());
        return flag;
    }



    public void hset(String key, String field, Object value) {
        if (null == jedisCluster) {
            return;
        }

        jedisCluster.hset(key.getBytes(), field.getBytes(), serializer.encode(value));
    }

    public Map<String, Object> hget(String key, Class clazz) {
        if (null == jedisCluster) {
            return null;
        }

        Map<byte[], byte[]> map = jedisCluster.hgetAll(key.getBytes());
        Map<String, Object> result = new HashMap<>();
        for (Map.Entry<byte[], byte[]> entry : map.entrySet()) {
            result.put(new String(entry.getKey()),
                    serializer.decode(entry.getValue(), clazz));
        }
        return result;
    }


}
