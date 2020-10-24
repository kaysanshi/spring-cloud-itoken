package com.kaysanshi.itoken.service.posts.service.impl;

import com.kaysanshi.itoken.common.domain.TbPostsPost;
import com.kaysanshi.itoken.common.mapper.TbPostsPostMapper;
import com.kaysanshi.itoken.common.service.impl.BaseServiceImpl;
import com.kaysanshi.itoken.service.posts.service.PostsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author kay三石
 * @date:2019/8/4
 * 文章服务的接口
 */
@Service
@Transactional(readOnly = true)
public class PostsServiceImpl extends BaseServiceImpl<TbPostsPost, TbPostsPostMapper> implements PostsService<TbPostsPost> {

}
