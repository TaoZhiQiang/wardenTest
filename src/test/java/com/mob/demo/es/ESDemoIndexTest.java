package com.mob.demo.es;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.bytes.BytesReference;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.ToXContent.Params;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;

import com.lamfire.code.PUID;
import com.lamfire.elasticsearch.Mapper;

@SuppressWarnings("all")
public class ESDemoIndexTest {
	ESDemoIndex esDemoIndex = new ESDemoIndex();

	/*@Test
	public void show() {
		String indexName = "school";// 索引名称
		String typeName = "student";// 类型名称
		String id = "1";
		String jsonData = "{" + "\"name\":\"xiyan\"," + "\"birth\":\"2017-11-09\"," + "\"email\":\"zhi55215221@163.com\""
				+ "}";// json数据
		// 1.创建索引(ID可自定义也可以自动创建，此处使用自定义ID)
		esDemoIndex.createIndex(indexName, typeName, id, jsonData);
	}*/

	
	//主要是通过继承重新封装的Index类来获取里面对象的各种方法
	@Test
	public void test() {
		
		// 在集群上创建索引
		//esDemoIndex.createIndexAtCluster();
		
		System.out.println("--------添加的相关方法-------------");
		ESDemo entity = new ESDemo();
		// entity.setId(PUID.puidAsString());
		entity.setId("4");
		entity.setTestField("test4");
		// 存储整个对象
//		esDemoIndex.addIndex(entity);
		//esDemoIndex.addIndex(new Date(), entity);
		//以集合的形式进行数据的存储
//		List<ESDemo> list = new ArrayList<ESDemo>();
//		list.add(entity);
//		esDemoIndex.addIndexes(list);
		
		System.out.println("-------------删除相关的方法------------------");
		// 根据id删除指定字段
//		String id="1";
//		esDemoIndex.deleteById(id);
//		//根据别名alias删除
//		String alias = null;
//		List<String> removeIndexNames = null;
//		String addIndexName = null;
		//esDemoIndex.deleteAlias(alias);
		//删除别名alias和index的关联关系
		//esDemoIndex.deleteAndCreateAlias(alias, removeIndexNames, addIndexName);
		//删除MAPPING
		//esDemoIndex.deleteMappingAtCluster();
		
		System.out.println("----------------查询的相关方法--------------------");
		
		//根据指定id查询
//		ESDemo esDemo = esDemoIndex.get("2");
//		System.out.println(esDemo);
		//获取映射
//		Mapper<ESDemo> mapper = esDemoIndex.getMapper();
//		System.out.println(mapper);
		//获得索引数量
//		long count = esDemoIndex.count();
//		System.out.println(count);
		//获得指定字段的索引的数量
//		long count = esDemoIndex.count("testField", "test2");
//		System.out.println(count);
		//获得指定一段时间内索引的数量
//		esDemoIndex.countWithBetween(betweenField, beginOf, endOf);
		//查询query
		/*QueryBuilder query = new QueryBuilder() {
			
			public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			public BytesReference buildAsBytes(XContentType contentType) throws ElasticsearchException {
				// TODO Auto-generated method stub
				return null;
			}
			
			public BytesReference buildAsBytes() throws ElasticsearchException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		List<ESDemo> executeQuery = esDemoIndex.executeQuery(query);*/		
		//集群上是否存在该索引
//		boolean indexAtCluster = esDemoIndex.existIndexAtCluster();
//		System.out.println(indexAtCluster);
		//索引上是否存在
//		boolean exists = esDemoIndex.exists("3");
//		System.out.println(exists);
		
			

		/*
		 * SearchRequestBuilder searchRequestBuilder = esDemoIndex.createSearchRequestBuilder();
		 * 
		 * //多字段查询方法 String key = "1"; QueryStringQueryBuilder queryBuilder =
		 * new QueryStringQueryBuilder(key); queryBuilder.analyzer("ik_smart");
		 * queryBuilder.field("title").field("testField");
		 * searchRequestBuilder.setQuery(queryBuilder);
		 * 
		 * // 设置高亮显示 searchRequestBuilder.addHighlightedField("title");
		 * searchRequestBuilder.addHighlightedField("testField"); //设置高亮的颜色
		 * searchRequestBuilder .setHighlighterPreTags(
		 * "<span style=\"color:red\">");
		 * searchRequestBuilder.setHighlighterPostTags("</span>");
		 * 
		 * // 执行搜索,返回搜索响应信息 SearchResponse response =
		 * searchRequestBuilder.execute() .actionGet();
		 * 
		 * // 获取搜索的文档结果 SearchHits searchHits = response.getHits(); SearchHit[]
		 * hits = searchHits.getHits(); for (int i = 0; i < hits.length; i++) {
		 * SearchHit hit = hits[i]; // 将文档中的每一个对象转换json串值 String json =
		 * hit.getSourceAsString(); //使用工具类处理对应的json串
		 * 
		 * 
		 * }
		 */

		// 清空索引
		// esDemoIndex.clearIndex();
	}

}
