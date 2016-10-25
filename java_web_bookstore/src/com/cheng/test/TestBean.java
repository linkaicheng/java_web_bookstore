package com.cheng.test;

public class TestBean {
	private String name;
	private int id;
	private String num;

	public TestBean() {
		super();
	}

	public TestBean(String name, int id, String num) {
		super();
		this.name = name;
		this.id = id;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "TestBean [name=" + name + ", id=" + id + ", num=" + num + "]";
	}

}