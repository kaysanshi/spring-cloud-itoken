package com.kaysanshi.itoken.common.service;

import com.github.pagehelper.PageInfo;
import com.kaysanshi.itoken.common.domain.BaseDomain;

/**
 * @Author kay三石
 * @date:2019/8/3
 */
public interface BaseService<T extends BaseDomain> {

    int insert(T t, String createBy);

    int delete(T t);

    int count(T t);

    int update(T t, String updateBy);

    T selectOne(T t);

    PageInfo page(int pageNum, int pageSize,T t);
}
