package com.mob.demo.redis;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.lamfire.redis.Redis;
import com.lamfire.redis.RedisCli;
import com.lamfire.redis.RedisFactory;

import redis.clients.jedis.SortingParams;


/**
 * redis不同数据类型的方法
 * @author taozhq
 *
 */
@SuppressWarnings("all")
public class RedisDemo {

	//创建redis工厂对象
	private static RedisFactory redisFactory=null;
	//创建redis客户端对象
	private static RedisCli redisCli=null;
	private static Redis redis = RedisFactory.getInstance().getRedis(); 
	//指定存储的数据库
	private static final int DEFAULT_DB_INDEX = 0;
	private static boolean equals;

	//静态代码块，在类加载时直接加载对应的redis配置文件
	static{
		redisFactory=RedisFactory.getInstance("redis.properties");
		redisCli= redisFactory.getRedisCli();
	}
	
	
	// TODO Auto-generated catch block
	//1.redis的key功能函数
	public static void KeyOperate(){
		
		//清空数据
        //System.out.println("清空库中所有数据："+((Object) redis).flushDB());
		
		redisCli.select(DEFAULT_DB_INDEX);
        System.out.println("======================key=========================="); 
        
        // 判断key否存在 
        System.out.println("判断key999键是否存在："+redisCli.exists("key999")); 
        System.out.println("新增key01,value01键值对："+redisCli.set("key01", "value01")); 
        System.out.println("判断key01是否存在："+redisCli.exists("key01"));
        // 输出系统中所有的key
        System.out.println("新增key02,value02键值对："+redisCli.set("key02", "value02"));
        System.out.println("遍历系统中所有的key：");
        Set<String> keys = redisCli.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key);   
        }
        // 删除某个key,若key不存在，则忽略该命令。
        System.out.println("系统中删除key02: "+redisCli.del("key02"));
        System.out.println("判断key02是否存在："+redisCli.exists("key02"));
        // 设置 key01的过期时间
        System.out.println("设置 key01的过期时间为5秒:"+redisCli.expire("key01", 5));
        try{ 
            Thread.sleep(2000); 
        } 
        catch (InterruptedException e){ 
        } 
        // 查看某个key的剩余生存时间,永久生存或者不存在的都返回-1
        System.out.println("查看key01的剩余生存时间："+redisCli.ttl("key01"));
        // 移除某个key的生存时间
        //System.out.println("移除key01的生存时间："+redisCli.persist(byte数组));
        System.out.println("查看key01的剩余生存时间："+redisCli.ttl("key01"));
        // 查看key所储存的值的类型
        System.out.println("查看key所储存的值的类型："+redisCli.type("key01"));
        
        /*
         * 一些其他方法：1、修改键名：redisCli.rename("key6", "key0");
         *          2、将当前db的key移动到给定的db当中：redisCli.move("foo", 1)
         */
    }
	
	
	// TODO Auto-generated catch block
	//2.String功能
	public static void StringOperate() 
    {  
        System.out.println("======================String_1=========================="); 
        
        System.out.println("=============增=============");
        redisCli.set("key01","value01");
        redisCli.set("key02","value02");
        redisCli.set("key03","value03");
        System.out.println("已新增的3个键值对如下：");
        System.out.println(redisCli.get("key01"));
        System.out.println(redisCli.get("key02"));
        System.out.println(redisCli.get("key03"));
        
        System.out.println("=============删=============");  
        System.out.println("删除key03键值对："+redisCli.del("key03"));  
        System.out.println("获取key03键对应的值："+redisCli.get("key03"));
        
        System.out.println("=============改=============");
        //1、直接覆盖原来的数据
        System.out.println("直接覆盖key01原来的数据："+redisCli.set("key01","value01-update"));
        System.out.println("获取key01对应的新值："+redisCli.get("key01"));
        //2、直接覆盖原来的数据  
        System.out.println("在key02原来值后面追加："+redisCli.append("key02","+appendString"));
        System.out.println("获取key02对应的新值"+redisCli.get("key02")); 
   
        System.out.println("=============查=============");
        String keys = "key02";
		System.out.println("查询添加的数据："+redisCli.mget(keys));
        
		/** 
         * mset,mget同时新增，修改，查询多个键值对 
         * 等价于：
         * redisCli.set("name","ssss"); 
         * redisCli.set("jarorwar","xxxx"); 
         */ 
		
		//一些特殊的添加和查询的方法
//      byte[] keysvalues={01,02,03,04};
//		System.out.println("一次性新增多个key对应值："+redisCli.mset(keysvalues));
        System.out.println("一次性获取多个key各自对应的值："+
        		redisCli.mget("key01","key02"));
        System.out.println("一次性删除多个key："+redisCli.del(keys));
//        System.out.println("一次性获取多个key各自对应的值："+
//        		redisCli.mget("1","2","3","4")); 
        System.out.println();
                
            
        //redisCli具备的功能redisCli中也可直接使用，下面测试一些前面没用过的方法
        System.out.println("======================String_2=========================="); 
        // 清空数据 
        //System.out.println("清空库中所有数据："+redisCli.flushDB());       
       
        System.out.println("=============新增键值对时防止覆盖原先值=============");
        System.out.println("原先key301不存在时，新增key301："+redisCli.setnx("key301", "value301"));
        System.out.println("原先key302不存在时，新增key302："+redisCli.setnx("key302", "value302"));
        System.out.println("当key302存在时，尝试新增key302："+redisCli.setnx("key302", "value302_new"));
        System.out.println("获取key301对应的值："+redisCli.get("key301"));
        System.out.println("获取key302对应的值："+redisCli.get("key302"));
        
        System.out.println("=============超过有效期键值对被删除=============");
        // 设置key的有效期，并存储数据 
        System.out.println("新增key303，并指定过期时间为2秒"+redisCli.setex("key303", 2, "key303-2second")); 
        System.out.println("获取key303对应的值："+redisCli.get("key303")); 
        try{ 
            Thread.sleep(3000); 
        } 
        catch (InterruptedException e){ 
        } 
        System.out.println("3秒之后，获取key303对应的值："+redisCli.get("key303")); 
        
        System.out.println("=============获取原值，直接更新为新值=============");
        System.out.println("key302原值："+redisCli.getSet("key302", "value302-after-getset"));
        System.out.println("key302新值："+redisCli.get("key302"));
        
        System.out.println("=============获取子串=============");
        System.out.println("获取key302对应值中的子串："+redisCli.getrange("key302", 5, 7));         
    } 
	
	
	// TODO Auto-generated catch block
	//3.list功能
	public static void ListOperate(){ 
        System.out.println("======================list=========================="); 

        System.out.println("=============增=============");
        redisCli.lpush("stringlists", "vector"); 
        redisCli.lpush("stringlists", "ArrayList"); 
        redisCli.lpush("stringlists", "vector");
        redisCli.lpush("stringlists", "vector");
        redisCli.lpush("stringlists", "LinkedList");
        redisCli.lpush("stringlists", "MapList");
        redisCli.lpush("stringlists", "SerialList");
        redisCli.lpush("stringlists", "HashList");
        redisCli.lpush("numberlists", "3");
        redisCli.lpush("numberlists", "1");
        redisCli.lpush("numberlists", "5");
        redisCli.lpush("numberlists", "2");
        System.out.println("所有元素-stringlists："+redisCli.lrange("stringlists", 0, -1));
        System.out.println("所有元素-numberlists："+redisCli.lrange("numberlists", 0, -1));
        
        System.out.println("=============删=============");
        // 删除列表指定的值 ，第二个参数为删除的个数（有重复时），后add进去的值先被删，类似于出栈
        System.out.println("成功删除指定元素个数-stringlists："+redisCli.lrem("stringlists", 2, "vector")); 
        System.out.println("删除指定元素之后-stringlists："+redisCli.lrange("stringlists", 0, -1));
        // 删除区间以外的数据 
        System.out.println("删除下标0-3区间之外的元素："+redisCli.ltrim("stringlists", 0, 3));
        System.out.println("删除指定区间之外元素后-stringlists："+redisCli.lrange("stringlists", 0, -1));
        // 列表元素出栈 
        System.out.println("出栈元素："+redisCli.lpop("stringlists")); 
        System.out.println("元素出栈后-stringlists："+redisCli.lrange("stringlists", 0, -1));
        
        System.out.println("=============改=============");
        // 修改列表中指定下标的值 
        redisCli.lset("stringlists", 0, "hello list!"); 
        System.out.println("下标为0的值修改后-stringlists："+redisCli.lrange("stringlists", 0, -1));
        System.out.println("=============查=============");
        // 数组长度 
        System.out.println("长度-stringlists："+redisCli.llen("stringlists"));
        System.out.println("长度-numberlists："+redisCli.llen("numberlists"));
        // 排序 
        
       /*注意：
        * 使用list存储字符串时必须指定参数为alpha，如果不使用SortingParams对象，而是直接使用sort("list")，
                         会出现"ERR One or more scores can't be converted into double"*/
         
        SortingParams sortingParameters = new SortingParams();
        sortingParameters.alpha();
        sortingParameters.limit(0, 3);
        System.out.println("返回排序后的结果-stringlists："+redisCli.sort("stringlists",sortingParameters)); 
        System.out.println("返回排序后的结果-numberlists："+redisCli.sort("numberlists"));
        // 子串：  start为元素下标，end也为元素下标；-1代表倒数一个元素，-2代表倒数第二个元素
        System.out.println("子串-第二个开始到结束："+redisCli.lrange("stringlists", 1, -1));
        // 获取列表指定下标的值 
        System.out.println("获取下标为2的元素："+redisCli.lindex("stringlists", 2)+"\n");
    } 
	
	// TODO Auto-generated catch block
	//4.set功能
	public static void SetOperate() 
	    { 

	        System.out.println("======================set=========================="); 
	        
	        System.out.println("=============增=============");
	        System.out.println("向sets集合中加入元素element01："+redisCli.sadd("sets", "element01")); 
	        System.out.println("向sets集合中加入元素element02："+redisCli.sadd("sets", "element02")); 
	        System.out.println("向sets集合中加入元素element03："+redisCli.sadd("sets", "element03"));
	        System.out.println("向sets集合中加入元素element04："+redisCli.sadd("sets", "element04"));
	        System.out.println("查看sets集合中的所有元素:"+redisCli.smembers("sets")); 
	        System.out.println();
	        
	        System.out.println("=============删=============");
	        System.out.println("集合sets中删除元素element03："+redisCli.srem("sets", "element03"));
	        System.out.println("查看sets集合中的所有元素:"+redisCli.smembers("sets"));
	        System.out.println("sets集合中任意位置的元素出栈："+redisCli.spop("sets"));//注：出栈元素位置不固定
	        System.out.println("查看sets集合中的所有元素:"+redisCli.smembers("sets"));
	        System.out.println();
	        
	        System.out.println("=============改=============");
	        System.out.println("没有对应修改方法:"+redisCli.sadd("sets", "element001"));
	        
	        System.out.println("=============查=============");
	        System.out.println("判断element01是否在集合sets中："+redisCli.sismember("sets", "element01"));
	        System.out.println("循环查询获取sets中的每个元素：");
	        Set<String> set = redisCli.smembers("sets");   
	        Iterator<String> it=set.iterator() ;   
	        while(it.hasNext()){   
	            Object obj=it.next();   
	            System.out.println(obj);   
	        }  
	        System.out.println();
	        
	        System.out.println("=============集合运算=============");
	        //System.out.println("sets1中添加元素element01："+redisCli.sadd(key, member)); 
	        System.out.println("sets1中添加元素element01："+redisCli.sadd("sets1", "element01")); 
	        System.out.println("sets1中添加元素element02："+redisCli.sadd("sets1", "element02")); 
	        System.out.println("sets1中添加元素element03："+redisCli.sadd("sets1", "element03")); 
	        System.out.println("sets1中添加元素element02："+redisCli.sadd("sets2", "element02")); 
	        System.out.println("sets1中添加元素element03："+redisCli.sadd("sets2", "element03")); 
	        System.out.println("sets1中添加元素element004："+redisCli.sadd("sets2", "element004"));
	        System.out.println("查看sets1集合中的所有元素:"+redisCli.smembers("sets1"));
	        System.out.println("查看sets2集合中的所有元素:"+redisCli.smembers("sets2"));

//	        byte[] keys = null;
//	        System.out.println("sets1和sets2交集："+redisCli.sinter(keys));       
//	        System.out.println("sets1和sets2并集："+redisCli.sunion(keys));
//	        System.out.println("sets1和sets2差集："+redisCli.sdiff(keys));//差集：set1中有，set2中没有的元素
	        
	    }
	
	// TODO Auto-generated catch block
	//5.zSet功能
	public static void SortedSetOperate() 
    { 
        System.out.println("======================zset=========================="); 
      
        System.out.println("=============增=============");
        
        //System.out.println("zset中添加元素element01："+redisCli.zadd(key, score, member)); 
        System.out.println("zset中添加元素element01："+redisCli.zadd("zset", 7.0, "element01")); 
        System.out.println("zset中添加元素element02："+redisCli.zadd("zset", 8.0, "element02")); 
        System.out.println("zset中添加元素element03："+redisCli.zadd("zset", 2.0, "element03")); 
        System.out.println("zset中添加元素element004："+redisCli.zadd("zset", 3.0, "element004"));
        System.out.println("zset集合中的所有元素："+redisCli.zrange("zset", 0, -1));//按照权重值排序
        System.out.println();
        
        System.out.println("=============删=============");
        System.out.println("zset中删除元素element02："+redisCli.zrem("zset", "element02"));
        System.out.println("zset集合中的所有元素："+redisCli.zrange("zset", 0, -1));
        System.out.println();
        
        System.out.println("=============改=============");
        System.out.println();
        
        System.out.println("=============查=============");
        System.out.println("统计zset集合中的元素中个数："+redisCli.zcard("zset"));
        System.out.println("统计zset集合中权重某个范围内（1.0——5.0），元素的个数："+redisCli.zcount("zset", 1.0, 5.0));
        System.out.println("查看zset集合中element004的权重："+redisCli.zscore("zset", "element004"));
        System.out.println("查看下标1到2范围内的元素值："+redisCli.zrange("zset", 1, 2));

    }
	
	// TODO Auto-generated catch block
	//6.hash功能
	public static void HashOperate() 
    { 
        System.out.println("======================hash==========================");
        
        System.out.println("=============增=============");
        System.out.println("hashs中添加key01和value01键值对："+redisCli.hset("hashs", "key01", "value01")); 
        System.out.println("hashs中添加key02和value02键值对："+redisCli.hset("hashs", "key02", "value02")); 
        System.out.println("hashs中添加key03和value03键值对："+redisCli.hset("hashs", "key03", "value03"));
        System.out.println("新增key004和4的整型键值对："+redisCli.hincrBy("hashs", "key004", 4l));
        System.out.println("hashs中的所有值："+redisCli.hvals("hashs"));
        System.out.println();
        
        System.out.println("=============删=============");
        System.out.println("hashs中删除key02键值对："+redisCli.hdel("hashs", "key02"));
        System.out.println("hashs中的所有值："+redisCli.hvals("hashs"));
        System.out.println();
        
        System.out.println("=============改=============");
        System.out.println("key004整型键值的值增加100："+redisCli.hincrBy("hashs", "key004", 100l));
        System.out.println("hashs中的所有值："+redisCli.hvals("hashs"));
        System.out.println();
        
        System.out.println("=============查=============");
        System.out.println("判断key03是否存在："+redisCli.hexists("hashs", "key03"));
        System.out.println("获取key004对应的值："+redisCli.hget("hashs", "key004"));
        System.out.println("批量获取key01和key03对应的值："+redisCli.hmget("hashs", "key01", "key03")); 
        System.out.println("获取hashs中所有的key："+redisCli.hkeys("hashs"));
        System.out.println("获取hashs中所有的value："+redisCli.hvals("hashs"));
        System.out.println();
              
    }
	
	
	/*//尝试各种方法
	@SuppressWarnings("all")
	public static String show(){
		String v = redisCli.get("1");
		
		Long append = redisCli.append("2", "追加");
		System.out.println(append);
		
		Long del = redisCli.del("1");
		System.out.println(del);
		
		
		Long hdel = redisCli.hdel("20171103_1", "");
		System.out.println(hdel);
		
		Boolean exists = redisCli.exists("2");
		System.out.println(exists);
		
		//redisFactory有的方法，redisCli都有
		
		try {
			redisCli.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	
	//直接通过客户端对象来进行存储操作
	public static String set(String key,String value){
		//设置默认数据库
		redisCli.select(DEFAULT_DB_INDEX);
		return redisCli.set(key, value);
		
	}
	
	//查询操作
	public static String get(String key) {
		redisCli.select(DEFAULT_DB_INDEX);
		return redisCli.get(key);
	}
	
	//客户端对象来操作删除功能
	public static Long del(String key) {
		redisCli.select(DEFAULT_DB_INDEX);
		return redisCli.del(key);
	}
	
	
	//通过客户端去jsdis中获取对应的redisCli来操作hash类型的存储
	public static Long hset(String key,String field,String value){
		//创建redisCli对象
		redisCli redisCli=null;
		try {
			//使用客户端对象获取对应的redisCli
			redisCli=redisCli.getredisCli();
			//设置存在时间
			redisCli.expire(key, 60);
			return redisCli.hset(key, field, value);
		} catch (Exception e) {
			return null;
		}finally{
			//关闭连接
			if (redisCli!=null) {
				redisCli.close();
			}
		}
		
		
	}
	
	//查询hash类型的数据（map作为key存储，再将map里的key作为查询条件）
	public static String hget(String key, String field) {
		redisCli redisCli = null;
		try {
			redisCli = redisCli.getredisCli();
			redisCli.expire(key, 60);
			return redisCli.hget(key, field);
		} catch (Exception e) {
			return null;
		} finally {
			if (redisCli != null)
				redisCli.close();
		}
	}
	
	
	//通过管道操作
	public static Long hincrBy(String key,String field,Long value){
		//初始化redisCli
		redisCli redisCli =null;
		try {
			//获取redisCli连接
			redisCli = redisCli.getredisCli();
			//使用管道
			Pipeline pipelined =redisCli.pipelined();
			pipelined.hincrBy(key, field, value);
			//设置失效时间
			redisCli.expire(key, 60);
			//因为管道针对的是多个方法的调用，使用集合进行存储
			List<Object> syncAndReturnAll = pipelined.syncAndReturnAll();
			//对返回值进行判断
			if (syncAndReturnAll==null || syncAndReturnAll.size()<1) {
				return null;
			}
			return Long.valueOf(syncAndReturnAll.get(0).toString());
		} catch (Exception e) {
			return null;
		}finally {
			//关连接
			if (redisCli!=null) {
				redisCli.close();
			}
		}
		
		
	}*/


	private byte[] keysvalues(String string, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8) {
		// TODO Auto-generated method stub
		return null;
	}


	public static boolean isEquals() {
		return equals;
	}


	public static void setEquals(boolean equals) {
		RedisDemo.equals = equals;
	}
	
}
