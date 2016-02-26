package com.chni.bp88a_server.model;
/**
 * 响应信息
 * @author lidong
 *
 */
public class SocketResponse {
	/**
	 * 返回信息
	 */
	private byte[] data;

	private String oper;
	
	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public byte[]  getData() {
		return data;
	}
	
	
	
}
