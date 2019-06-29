package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author kay三石
 * @date:2019/6/19
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T>{

}
