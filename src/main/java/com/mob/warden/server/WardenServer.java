package com.mob.warden.server;

import com.lamfire.warden.HttpServer;

/**
 * 熟悉框架
 * @author taozhq
 *
 */
public class WardenServer {
	public static void main(String[] args) {
		try {
			HttpServer server=new HttpServer(8080);
			String name = "com.mob.warden.action";
			server.registerAll(name);
			//启动server服务
			server.startup();
			//打印对应服务的端口号
			System.out.println("Http Server listening on 8080 ...");
			
			//关闭服务
			//server.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
