package com.sk.user.provider.utils;

import com.sk.user.provider.exception.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 序列化list
 *
 * @Author Hugo.Wwg
 * @Since 2019-04-22
 */
public class SerializeUtils {
    private static Logger logger = LoggerFactory.getLogger(SerializeUtils.class);

    public static byte[] encodeList(List<?> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        byte[] bytes;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            for (Object obj : list) {
                oos.writeObject(obj);
            }
            bytes = baos.toByteArray();
        } catch (Exception e) {
            logger.error("redis list序列化异常");
            throw new AppException(e.getMessage());
        } finally {
            close(oos);
            close(baos);
        }
        return bytes;
    }

    public static List<Object> decodeList(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        List<Object> list = new ArrayList<>();
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            while (bais.available() > 0) {
                Object obj = ois.readObject();
                if (obj == null) {
                    break;
                }
                list.add(obj);
            }
        } catch (Exception e) {
            logger.error("redis list反序列化异常");
            throw new AppException(e.getMessage());
        } finally {
            close(bais);
            close(ois);
        }
        return list;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                logger.error("IO流关闭异常");
                throw new AppException(e.getMessage());
            }
        }
    }

}
