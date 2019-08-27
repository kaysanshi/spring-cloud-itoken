package com.kayleoi.itoken.service.posts.mapper;

import com.kayleoi.itoken.common.domain.TbPostsPost;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

@Repository
public interface TbPostsPostExtendMapper extends MyMapper<TbPostsPost> {
}