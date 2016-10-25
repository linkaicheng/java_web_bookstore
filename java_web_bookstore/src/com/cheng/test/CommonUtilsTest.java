package com.cheng.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.cheng.utils.CommonUtils;

public class CommonUtilsTest {

	// @Test
	public void testUuid() {
		String uuid = CommonUtils.uuid();
		System.out.println(uuid);
	}

	@Test
	public void testToBean() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "linkaicheng");
		map.put("id", "1");
		map.put("num", "30");
		TestBean testBean = CommonUtils.toBean(map, TestBean.class);
		System.out.println(testBean);
	}

}
