package com.mob.demo.es;

import java.util.Properties;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;

import com.lamfire.elasticsearch.Cluster;
import com.lamfire.elasticsearch.ClusterFactory;
import com.lamfire.elasticsearch.Index;
import com.lamfire.utils.PropertiesUtils;


@SuppressWarnings("all")
public class ESDemoIndex extends Index<ESDemo> {

	private static Properties pro;
	private static Cluster cluster;
	Client client =new TransportClient();

	static {
		pro = PropertiesUtils.load("elastics.properties", ESDemoIndex.class);
		cluster = ClusterFactory.getCluster(pro.getProperty("es.cluster.name"));
	}

	protected ESDemoIndex() {
		this(cluster);
	}

	protected ESDemoIndex(Cluster cluster) {
		super(cluster);
	}

//	//创建索引
//	public void createIndex(String indexName, String typeName, String id, String jsonData) {
//		// TODO Auto-generated method stub
//		IndexRequestBuilder requestBuilder = client.prepareIndex(indexName, typeName, id).setRefresh(true);// 设置索引名称，索引类型，id
//		requestBuilder.setSource(jsonData).execute().actionGet();// 创建索引
//	}
	


}
