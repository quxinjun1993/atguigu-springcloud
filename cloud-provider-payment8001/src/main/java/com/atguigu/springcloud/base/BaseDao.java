package com.atguigu.springcloud.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 公用Mapper接口
 * @param <T>
 */
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T> {
}
