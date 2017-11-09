package com.mob.demo.action;

import org.junit.Test;

import com.lamfire.utils.HttpClient;
import com.lamfire.utils.URLUtils;


public class WardenActionTest2 {

	@Test
	public void testExecute() throws Exception {
		//拼接完整服务路径
		//String url = "http://localhost:" + 8080 + "/warden";
		//创建客户端对象
		final HttpClient client = new HttpClient();
		//请求方式
		client.setMethod("get");
		client.setCharset("UTF-8");
		client.setConnectTimeout(180000);
		client.setReadTimeout(180000);
				
		//get方法和post方法其实最本质的区别就是字面意思，get方法的传递形式
		client.open("http://localhost:8080/warden?name="+URLUtils.encode("lamfire(测试)","utf-8")+"&age=25&items=1&items=2");
		byte[] ret = client.read();
	    System.out.println(ret);	
	}
}
