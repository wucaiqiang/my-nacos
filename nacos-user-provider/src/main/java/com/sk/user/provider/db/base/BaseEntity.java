package com.sk.user.provider.db.base;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 所有DB实体必须继承此类
 *
 * @author Jack
 *
 * @version 0.0.1 Apr 2, 2019
 *
 * @Copyright: 2019 Lezhu Inc. All rights reserved.
 *
 *
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 455297627761691880L;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
