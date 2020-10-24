package com.kaysanshi.itoken.service.redis.service;

/**
 * @Author kay三石
 * @date:2019/6/27
 */
public interface RedisService {
   /**
    *设置值
    * @param key
    * @param value
    * @param seconds  由于设置，几秒秒之内查询有结果，十秒之后返回为null
    */
   public void set(String key, String value, long seconds);

   /**
    *取得返回结果
    * @param key
    * @return
    */
   public Object get(String key);

   /**
    * 设置中不加入超时时间
    * @param key
    * @param value
    */
   public void set(String key,String value);



}
