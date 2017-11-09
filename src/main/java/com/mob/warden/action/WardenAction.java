package com.mob.warden.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lamfire.warden.Action;
import com.lamfire.warden.ActionContext;
import com.lamfire.warden.HttpRequestParameters;
import com.lamfire.warden.anno.ACTION;

/**
 * 测试整个框架流程
 * @author taozhq
 *
 */
@ACTION(path="/warden",singleton=true)
public class WardenAction implements Action{
	
	//json数据的传递，链接的传递，还有文本数据的传递

	public void execute(ActionContext context) {
		//获取传递的参数
		String requestBodyAsString = context.getRequestBodyAsString();
		System.out.println(requestBodyAsString);
		
		Set<String> requestHeaderNames = context.getRequestHeaderNames();
		for (String name : requestHeaderNames) {
			String value = context.getRequestHeader(name);
			System.out.println(name+"="+value);
		}
		
		
		HttpRequestParameters parameters = context.parameters();
		Map<String, List<String>> all = parameters.all();
		for(Map.Entry<String, List<String>> entry : all.entrySet()){
			System.out.println(entry.getKey() + " = " + entry.getValue().get(0));
		}
	}
}
