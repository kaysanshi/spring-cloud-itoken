package tk.mybatis.mapper;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author kay三石
 * @date:2019/6/19
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T>{

}
