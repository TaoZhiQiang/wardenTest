package com.mob.demo.mongo;

import java.util.List;

import org.junit.Test;

import com.lamfire.jmongo.query.Query;
import com.lamfire.jmongo.query.UpdateOperations;
import com.lamfire.jmongo.query.UpdateResults;


@SuppressWarnings("all")
public class MongoDemoDaoTest {
	MongoDemoDao mongoDao = new MongoDemoDao();
	
	
	@Test
	public void testInsert() {
		
		MongoDemo testMongo = new MongoDemo();
		testMongo.setId("1");
		testMongo.setTestField("自用");
		mongoDao.insert(testMongo);
	}
	
	//测试mongo的各种方法
	@Test
	public void testShow(){
		
		//保存对象类型数据
//		MongoDemo entity = new MongoDemo();
//		mongoDao.save(entity);
//		mongoDao.insert(entity);
		
		
		//删除实体类对象
//		MongoDemo entity = new MongoDemo();
//		mongoDao.delete(entity );
//		//根据指定id删除
//		mongoDao.deleteById("id");
//		Query<MongoDemo> q = null;
//		mongoDao.deleteByQuery(q);
		
		//更新字段
//		UpdateOperations<MongoDemo> createUpdateOperations = mongoDao.createUpdateOperations();
//		createUpdateOperations.set("testField", "test1");
//		mongoDao.update("3", createUpdateOperations);
//		mongoDao.update("2", "testField", "test2");	
//		//自增操作
//		createUpdateOperations.inc("testField");
		
		
		//查询总数
		//获取总记录数
//		long count = mongoDao.count();
//		System.out.println("总记录数:"+count);
//		
		Query<MongoDemo> createQuery = mongoDao.createQuery();
//		long countAll = createQuery.countAll();
//		System.out.println("所有："+countAll);

//		//所有结果的集合
//		List<Key<MongoDemo>> asKeyList = createQuery.asKeyList();
//		System.out.println(asKeyList);
		
//		List<String> ids = mongoDao.findIds("testField", "test2");
//		System.out.println(ids);
		
//		List<MongoDemo> asList = createQuery.asList();
//		System.out.println(asList.size());		
		//分页查询
//		createQuery.offset(1);
//		createQuery.limit(Integer.MAX_VALUE);
		
		
		//其他方法
		//比较
//		createQuery.field("id").equal(id);
//		createQuery.filter("id", id);
		//是否存在
//		createQuery.field("id").exists();
		
		
	}
	
	@Test
	public void ShowDemo(){
		List<MongoDemo> list = mongoDao.show();
		for (MongoDemo mongoDemo : list) {
			System.out.println(mongoDemo);
		}
	}

}
