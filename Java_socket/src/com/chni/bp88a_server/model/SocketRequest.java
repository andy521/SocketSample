package com.chni.bp88a_server.model;

/**
 * 
 * 请求参数
 */
public class SocketRequest {

	private String operation;//获取操作
	private String data;//数据
	private int length;//数组的长度

	public SocketRequest(){}
	
	public SocketRequest(String requestStr,int lenght) {
		if (requestStr != null || "".equals(requestStr)) {
			this.operation = requestStr.substring(8, 10);
			this.data = requestStr;
			this.length =lenght;
		}
	}

	public String getOperation() {
		return this.operation;
	}

	public String getData() {
		return this.data;
	}

	public int getLength() {
		return length;
	}

	public static void main(String[] args) {

	}

	public void setData(String data) {
		this.data = data;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
}