package com.mob.demo.redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import com.lamfire.redis.RedisCli;
import com.lamfire.redis.RedisFactory;

/**
 * 限制app的发送数量和手机号码的发送数量的redis User: luob Date: 15-12-3 Time: 下午5:54 To change
 * this template use File | Settings | File Templates.
 */
public class RedisDemo {

	private static RedisFactory redisFactory = null;
	private static RedisCli redisCli = null;
	private static final int DEFAULT_DB_INDEX = 0;

	static {
		redisFactory = RedisFactory.getInstance("redis.properties");
		redisCli = redisFactory.getRedisCli();
	}

	public static String set(String key, String value) {
		redisCli.select(DEFAULT_DB_INDEX);
		return redisCli.set(key, value);
	}

	public static String get(String key) {
		redisCli.select(DEFAULT_DB_INDEX);
		return redisCli.get(key);
	}

	public static Long hset(String key, String field, String value) {
		Jedis jedis = null;
		try {
			jedis = redisCli.getJedis();
			jedis.expire(key, 60);
			return jedis.hset(key, field, value);
		} catch (Exception e) {
			return null;
		} finally {
			if (jedis != null)
				jedis.close();
		}
	}

	public static String hget(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = redisCli.getJedis();
			redisCli.expire(key, 60);
			return jedis.hget(key, field);
		} catch (Exception e) {
			return null;
		} finally {
			if (jedis != null)
				jedis.close();
		}
	}

	public static Long hincrBy(String key, String field, Long value) {
		Jedis jedis = null;
		try {
			jedis = redisCli.getJedis();
			Pipeline pipelined = jedis.pipelined();
			pipelined.hincrBy(key, field, value);
			pipelined.expire(key, 60);
			List<Object> syncAndReturnAll = pipelined.syncAndReturnAll();
			if (syncAndReturnAll == null || syncAndReturnAll.size() < 1) {
				return null;
			}
			return Long.valueOf(syncAndReturnAll.get(0).toString());
		} catch (Exception e) {
			return null;
		} finally {
			if (jedis != null)
				jedis.close();
		}
	}
}
