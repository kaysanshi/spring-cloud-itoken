package com.kaysanshi.itoken.common.mapper;

import com.kaysanshi.itoken.common.domain.TbSysUser;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

@Mapper
public interface TbSysUserMapper extends MyMapper<TbSysUser> {
}