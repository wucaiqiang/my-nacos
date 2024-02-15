package com.sk.user.provider.db.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用Mapper
 *
 * @author Jack
 *
 * @version 0.0.1 Apr 2, 2019
 *
 * @Copyright: 2019 Lezhu Inc. All rights reserved.
 *
 * @param <T>
 *
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
