package com.mob.demo.es;

import com.lamfire.elasticsearch.annotation.Entity;
import com.lamfire.elasticsearch.annotation.Id;
import com.lamfire.elasticsearch.annotation.IndexCycleTime;
import com.lamfire.elasticsearch.annotation.Indexed;


@Entity(indexName = "sms_demo", indexType = "sms_demo", indexCycleTime = IndexCycleTime.DAY)
public class ESDemo {
	@Id
	private String id;

	@Indexed
	private String testField;

	private String title;

	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTestField() {
		return testField;
	}

	public void setTestField(String testField) {
		this.testField = testField;
	}

	@Override
	public String toString() {
		return "ESDemo [id=" + id + ", testField=" + testField + "]";
	}

	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title=title;
	}

	public void setContent(String content) {
		// TODO Auto-generated method stub
		this.content=content;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
}
