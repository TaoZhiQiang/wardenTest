package com.mob.demo.mongo;

import java.util.List;

import com.lamfire.jmongo.Key;
import com.lamfire.jmongo.dao.DAOSupport;
import com.lamfire.jmongo.query.Query;

/**
 * 操作mongo的相关方法，查询自用
 * @author taozhq
 *
 */
public class MongoDemoDao extends DAOSupport<MongoDemo, String> {


	//使用构造函数初始化对应数据库
	public MongoDemoDao() {
		super("smssdk", "test", MongoDemo.class);
	}

	public MongoDemoDao(String mongoName, String dbName, Class<MongoDemo> clazz) {
		super(mongoName, dbName, clazz);
	}
	

	@Override
	public Key<MongoDemo> insert(MongoDemo entity) {
		return super.insert(entity);
	}	
	
	
	public List<MongoDemo> show(){
		Query<MongoDemo> createQuery = createQuery();
		
		createQuery.field("_id").exists();
		
		//分页
		createQuery.offset(0);
		createQuery.limit(Integer.SIZE);
				
		return createQuery.asList();
		
	}

}
