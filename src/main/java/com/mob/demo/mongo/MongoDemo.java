package com.mob.demo.mongo;

import com.lamfire.jmongo.annotations.Entity;
import com.lamfire.jmongo.annotations.Id;


@Entity("demo")
public class MongoDemo {

	@Id
	private String id;
	private String testField;

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
		return "MongoDemo [id=" + id + ", testField=" + testField + "]";
	}
	
	
}
