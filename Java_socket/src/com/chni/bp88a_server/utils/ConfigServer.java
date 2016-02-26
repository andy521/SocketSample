package com.chni.bp88a_server.utils;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 服务器配置信息
 * @author Administrator
 *
 */
public class ConfigServer {
     
	private  static Map<String,String>  cfgMap= new HashMap<String,String>();
	static{
		try {
			loadXml("/config/server.xml");
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static void loadXml(String fileName ) throws DocumentException {
		Document doc = parseXml(fileName);
		processData(doc);
	}
	public static void processData(Document doc) {
		Element   e=(Element)
				doc.selectSingleNode("/servers/server");
		Iterator<?> it = e.elementIterator();
		while(it.hasNext()){
			Element e1 = (Element) it.next();
			cfgMap.put(e1.getName(), e1.getTextTrim());
		}
	}
	public static Document parseXml(String fileName) throws DocumentException {
		URL url = ConfigServer.class.getResource(fileName);
    	SAXReader  saxReader=new SAXReader();
		Document doc = saxReader.read(url);
		return doc;
	}
	public  static String getValue(String key){
		return cfgMap.get(key);
		
	}
	public static void main(String[] args) {
	System.out.println(getValue("port"));
	}
}
