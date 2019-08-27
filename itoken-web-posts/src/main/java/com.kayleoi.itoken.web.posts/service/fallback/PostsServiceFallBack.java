package com.kayleoi.itoken.web.posts.service.fallback;

import com.kayleoi.itoken.common.hystrix.FallBack;
import com.kayleoi.itoken.web.posts.service.PostsService;

/**
 * @Author kay三石
 * @date:2019/8/24
 */
public class PostsServiceFallBack implements PostsService {

    @Override
    public String page(int PageNum, int pageSize, int tbPostsPostJson) {
        return FallBack.badGateway();
    }
}
