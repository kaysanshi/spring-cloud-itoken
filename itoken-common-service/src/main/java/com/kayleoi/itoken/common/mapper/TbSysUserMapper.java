package com.kayleoi.itoken.common.mapper;

import com.kayleoi.itoken.common.domain.TbSysUser;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

@Mapper
public interface TbSysUserMapper extends MyMapper<TbSysUser> {
}