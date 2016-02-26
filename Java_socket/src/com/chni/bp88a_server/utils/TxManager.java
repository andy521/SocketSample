package com.chni.bp88a_server.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
/**
 * 
 * */
public class TxManager implements InvocationHandler{
     private  Object  obj;
     public Object getProxy(Object  obj) {
    	 this.obj=obj;
		return  Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), 
				this) ;
	}
	@Override
	public Object invoke(Object proxy,
			Method method, 
			Object[] args)
			throws Throwable {
		Object  result=null;
		Connection  conn=null;
		try{
		conn=DBUtil.getConn();
		conn.setAutoCommit(false);
		result=method.invoke(obj, args);
		conn.commit();
		return result;
		}catch(Exception e){
			if(conn!=null)  conn.rollback();
			throw  e;
		}finally{
		DBUtil.closeDB(conn);
		}
	}
}
