package com.mob.demo.action;

import java.io.IOException;
import org.junit.Test;

import com.lamfire.json.JSON;
import com.lamfire.utils.HttpClient;


public class WardenActionTest {

	@Test
	public void testExecute() {
		//拼接完整服务路径
		//String url = "http://localhost:" + 8080 + "/warden";
		//创建客户端对象
		final HttpClient client = new HttpClient();
		//请求方式
		client.setMethod("post");
		client.setCharset("UTF-8");
		client.setConnectTimeout(180000);
		client.setReadTimeout(180000);
		/*application/x-www-form-urlencoded ： 窗体数据被编码为名称/值对。这是标准的编码格式。
			multipart/form-data ： 窗体数据被编码为一条消息，页上的每个控件对应消息中的一个部分。
			text/plain ： 窗体数据以纯文本形式进行编码，其中不含任何控件或格式字符。*/
		//client.setContentType( "application/json");
		
		//请求json数据类型
		JSON json = new JSON();
		json.put("1", "测试");
		json.put("2", "再测试");
		
		JSON json1 = new JSON();
		json1.put("11", "测试");
		json1.put("12", "再测试");
		json.putAll(json1);
		
		
		//请求参数
		client.addPostParameter("param", "test");
		try {
			//action路径
			//client.open(url);
			
			client.open("http://localhost:8080/warden");
			
			//传递json类型
			client.post(json.toBytes());
			//传递string类型参数
			client.post();
			
			//byte[] ret = client.read();
		    //System.out.println(ret);
			
			//接收响应的状态码
			int responseCode = client.getResponseCode();
			//System.out.println(responseCode);
			if (responseCode == 200) {
				String res = client.readAsString();
				System.out.println(res);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
