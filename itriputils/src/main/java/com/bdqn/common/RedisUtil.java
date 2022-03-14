package com.bdqn.common;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisUtil {

    private static final Jedis jedis;

    static {
        jedis = new Jedis("localhost", 6379);
        jedis.auth("123456");
    }

    public void setKey(String key, String value, int second) {
        String str = jedis.setex(key, second, value);
    }

    public String getKey(String key) {
        return jedis.get(key);
    }

    public void delKey(String key){
        jedis.del(key);
    }

}
