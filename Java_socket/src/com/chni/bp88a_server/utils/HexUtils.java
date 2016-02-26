package com.chni.bp88a_server.utils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Locale;
/**
 * 数据转换的工具类
 * @author lidong
 *
 */
public class HexUtils {
	/**
	 * 将字节数组转化为16进制字符串
	 * @param bytes 字节数组
	 * @return  16进制字符串
	 */
	public static String bytes2HexString(byte[] bytes) {
		String ret = "";
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex.toLowerCase(Locale.CHINA);
		}
		return ret;
	}
    /**
     * 将16进制字符串转换字节
     * @param message 16进制字符串
     * @return  字节数组
     */
	public static byte[] getHexBytes(String message) {
		int len = message.length() / 2;
		char[] chars = message.toCharArray();
		String[] hexStr = new String[len];
		byte[] bytes = new byte[len];
		for (int i = 0, j = 0; j < len; i += 2, j++) {
			hexStr[j] = "" + chars[i] + chars[i + 1];
			bytes[j] = (byte) Integer.parseInt(hexStr[j], 16);
		}
		return bytes;
	}
	
	public static byte[] getByteArray(String hexString) {
		  return new BigInteger(hexString,16).toByteArray(); 
		}
	
	public static void main(String[] args) {
		
	       System.out.println(Arrays.toString(getHexBytes("aa5504b10000b5")));
	    }
	    
}
