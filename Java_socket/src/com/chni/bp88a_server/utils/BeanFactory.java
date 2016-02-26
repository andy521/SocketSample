package com.chni.bp88a_server.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class BeanFactory {

	private static Map<String, Object> map = new HashMap<String, Object>();
	static {
		try {
			loadBeans("/config/beans.xml");
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	@SuppressWarnings("unchecked")
	private static void loadBeans(String xml) throws Exception {
		SAXReader sax = new SAXReader();
		InputStream in = BeanFactory.class.getResourceAsStream(xml);
		try {
			Document doc = sax.read(in);
			List<Node> list = doc.selectNodes("/beans/bean");
			for (Node n : list) {
				map.put(n.valueOf("@name"), Class.forName(n.valueOf("@class"))
						.newInstance());
			}
		} finally {
			if (in != null)
				try {
					in.close();
					in.close();
				} catch (Exception e) {
				}
		}
	}

	public static Object getBean(String key) {
		return map.get(key);
	}

	public static void main(String[] args) {
		System.out.println(getBean("IBP88AService"));
	}
}
