package com.kaysanshi.itoken.common.constants;

/**
 * q请求的http
 * @Author kay三石
 * @date:2019/6/22
 */
public enum  HttpStatusConstants {
    BAD_GATEWAY(502,"从上游接受的数据无响应");

    private int status;
    private String content;

    private HttpStatusConstants(int status,String content){
        this.content=content;
        this.status=status;

    }
    public int getStatus(){
        return status;
    }
    public String getContent(){
        return content;
    }
}
