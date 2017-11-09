/**
 * Project Name:demo
 * File Name:TestRedisTest.java
 * Package Name:com.mob.demo.mongo.redis
 * Date: 2017年11月2日
 * Time: 下午4:54:32
 *
 */

package com.mob.demo.redis;

import org.junit.Test;

import com.lamfire.redis.Redis;
import com.lamfire.redis.RedisFactory;

/**
 * redis的对应操作方法：增改：det，删除：del，查询：get
 * 操作redis的方法：直接客户端段操作，通过客户端去对应的jedis池中获取jedis连接，通过管道Pipeline操作（操作多个时使用管道）
 * @author taozhq
 *
 */
@SuppressWarnings("all")
public class RedisDemoTest {
	
	//调用key的测试
	@Test
	public void keyOperate(){
		RedisDemo.KeyOperate();
	}
	
	//调用String的测试
	@Test
	public void stringOperate(){
		RedisDemo.StringOperate();
	}
	
	//调用list的测试
	@Test
	public void listOperate(){
		RedisDemo.ListOperate();
	}
	
	//调用list的测试
	@Test
	public void setOperate(){
		RedisDemo.SetOperate();
	}
	
	//调用zSet的测试
	@Test
	public void zSetOperate(){
		RedisDemo.SortedSetOperate();
	}
	
	//调用hash的测试
	@Test
	public void hashOperate(){
		RedisDemo.HashOperate();
	}
	
	/*//存取
	@Test
	public void testAdd(){
		Redis redis = RedisFactory.getInstance().getRedis(); 
		//key,value存储	
		redis.put("1", "心里急");
		String v =redis.get("1");
		System.out.println(v);
		
		//数组存储
		byte[] value = {1,2};
		byte[] key = {3,4};
		redis.put(key, value);
		byte[] bs = redis.get(key);
		System.out.println(bs.length);
	}
	
	//测试其他方法
	@Test
	public void testShow(){
		RedisDemo.show();
	}
	
	//尝试不同方法
	@Test
	public void testRemove(){
		Redis redis = RedisFactory.getInstance().getRedis(); 
		//删除方法
		//redis.remove("1");
		String value =redis.get("2");
		
		redis.decrease("");
		//判断是否存在
		boolean exists = redis.exists("1");
		
		String id = "2";
		redis.put(id, "出来");
		redis.getMap(id);
		
		byte[] id1 = {5,6};
		redis.getMap(id1);
		System.out.println(exists);
		System.out.println(value);
	}
	

	//测试向redis里面保存数据
	@Test
	public void testSet() {
		String key = "20171103_1";
		String value = "value";
		String set = RedisDemo.set(key, value);
		System.out.println(set);
	}
	
//	//zset
//	@Test
//	public void testZset(){
//		RedisDemo.s
//	}
	
	//根据指定key查询数据
	@Test
	public void testGet() {
		String key = "20171103_1";
		String get = RedisDemo.get(key);
		System.out.println(get);
	}
	
	//根据指定key删除数据
	@Test
	public void testDel() {
		String key = "20171103_1";
		Long get = RedisDemo.del(key);
		System.out.println(get);
	}
	
	//hset保存
	@Test
	public void testHset() {
		String key = "20171103_2";
		String field = "field";
		String value = "value1";
		Long hset = RedisDemo.hset(key, field, value);
		System.out.println(hset);
	}
	
	//hget查询
	@Test
	public void testHget() {
		String key = "20171103_2";
		String field = "field";
		String hget = RedisDemo.hget(key, field);
		System.out.println(hget);
	}

	@Test
	public void testHincrBy() {
		String key = "20171103_3";
		String field = "field";
		long value = 10L;
		Long hincrBy = RedisDemo.hincrBy(key, field, value);
		System.out.println(hincrBy);
		String hget = RedisDemo.hget(key, field);
		System.out.println(hget);
	}
*/
}
