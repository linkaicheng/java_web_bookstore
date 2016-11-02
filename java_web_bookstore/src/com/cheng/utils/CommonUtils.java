package com.cheng.utils;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

/**
 * 工具：返回不重复字符串的方法和将map转换成指定对象的方法
 * 
 * @author cheng
 *
 */
public class CommonUtils {
	/**
	 * 返回一个随机的32长不重复的字符串 用途：用来做id，数据库表中的主键是不能重复的，它就是不重复 激活码也是不能重复的，也可以用它
	 * 
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	/*
	 * 当用到BeanUtils的populate、copyProperties方法或者getProperty,
	 * setProperty方法其实都会调用convert进行转换
	 * 但Converter只支持一些基本的类型，甚至连java.util.Date类型也不支持。而且它比较笨的一个地方是当遇到不认识的类型时，
	 * 居然会抛出异常来。
	 * 这个时候就需要给类型注册转换器。比如：意思是所以需要转成Date类型的数据都要通过DateLocaleConverter这个转换器的处理。
	 * ConvertUtils.register(new DateLocaleConverter(), Date.class);
	 */

	/**
	 * 把map转换成指定的对象 作用：把一个map中的数据封装到javabean中 要求： 1要求map中的key名称与javabean中的属性名称相同
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static <T> T toBean(Map map, Class<T> clazz) {

		try {
			/*
			 * 1. 通过参数clazz创建实例 2. 使用BeanUtils.populate把map的数据封闭到bean中
			 */
			T bean = clazz.newInstance();
			ConvertUtils.register(new DateConverter(), java.util.Date.class);
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
