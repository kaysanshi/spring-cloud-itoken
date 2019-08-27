package com.kayleoi.itoken.service.posts.service.impl;

import com.kayleoi.itoken.common.domain.BaseDomain;
import com.kayleoi.itoken.common.domain.TbPostsPost;
import com.kayleoi.itoken.common.mapper.TbPostsPostMapper;
import com.kayleoi.itoken.common.service.impl.BaseServiceImpl;
import com.kayleoi.itoken.service.posts.service.PostsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.MyMapper;

/**
 * @Author kay三石
 * @date:2019/8/4
 * 文章服务的接口
 */
@Service
@Transactional(readOnly = true)
public class PostsServiceImpl extends BaseServiceImpl<TbPostsPost, TbPostsPostMapper> implements PostsService<TbPostsPost> {

}
