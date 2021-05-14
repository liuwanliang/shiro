package com.lwl.shiro_session.util;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

public class RedisUtils {
    private static ShardedJedisPool jedisPool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMaxWaitMillis(1000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);

        List<JedisShardInfo> list = new ArrayList<>();
        JedisShardInfo shardInfo = new JedisShardInfo("127.0.0.1");
        list.add(shardInfo);
        jedisPool = new ShardedJedisPool(config, list);
    }

    public static String set(String key, String value) {
        try (ShardedJedis jedis = jedisPool.getResource()) {
            return jedis.set(key, value);
        }
    }

    public static String get(String key) {

        try (ShardedJedis jedis = jedisPool.getResource()) {

            return jedis.get(key);
        }
    }

    /**
     * 从连接池中获取一个ShardedJedis对象
     */
    public static ShardedJedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 关闭ShardedJedis对象，放回池中
     */
    public static void closeJedis(ShardedJedis jedis) {
        jedis.close();
    }

    public static void main(String[] args) {
        System.out.println(RedisUtils.set("a", "aaaaaaaaaaaaa"));
        System.out.println(RedisUtils.get("a"));
    }
}
