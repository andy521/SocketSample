package com.chni.bp88a_server.utils;

/**
 * 数据解析工具类
 * 
 * @author lidong
 * 
 */
public class DataParseUtil {

	/**
	 * 解析时间数据
	 * 
	 * @param date
	 * @return
	 */
	public static String[] parseDate(String date) {
		String[] ss = new String[5];
		ss[0] = Integer.parseInt(date.substring(0, 2), 16) > 10 ? Integer
				.parseInt(date.substring(0, 2), 16)
				+ "" : "0" + Integer.parseInt(date.substring(0, 2), 16);
		ss[1] = Integer.parseInt(date.substring(2, 4), 16) > 10 ? Integer
				.parseInt(date.substring(2, 4), 16)
				+ "" : "0" + Integer.parseInt(date.substring(2, 4), 16);
		ss[2] = Integer.parseInt(date.substring(4, 6), 16) > 10 ? Integer
				.parseInt(date.substring(4, 6), 16)
				+ "" : "0" + Integer.parseInt(date.substring(4, 6), 16);
		if (Integer.parseInt(date.substring(6, 8), 16) > 10) {
			ss[3] = "" + Integer.parseInt(date.substring(6, 8), 16);
		} else {
			if (Integer.parseInt(date.substring(6, 8), 16) == 10) {
				ss[3] = "" + Integer.parseInt(date.substring(6, 8), 16);
			} else {
				ss[3] = "0" + Integer.parseInt(date.substring(6, 8), 16);
			}
		}
		ss[4] = Integer.parseInt(date.substring(8, 10), 16) > 10 ? Integer
				.parseInt(date.substring(8, 10), 16)
				+ "" : "0" + Integer.parseInt(date.substring(8, 10), 16);
		return ss;

	}

	/**
	 * 解析血压数据
	 * 
	 * @param bloodPressure
	 * @return
	 */
	public static String[] parseBloodPressure(String bloodPressure) {
		String[] ss = new String[3];
		ss[0] = Integer.parseInt(bloodPressure.substring(0, 4), 16) + "";
		ss[1] = Integer.parseInt(bloodPressure.substring(4, 8), 16) + "";
		ss[2] = Integer.parseInt(bloodPressure.substring(8, 10), 16) + "";
		return ss;

	}

	/**
	 * 解析设备的信息
	 * 
	 * @param device_sn
	 * @return
	 */
	public static String[] parseDevicSn(String device_sn) {
		String[] ss = new String[4];
		if (Integer.parseInt(device_sn.substring(0, 2), 16) > 10) {
			ss[0] = Integer.parseInt(device_sn.substring(0, 2), 16) + "";
		} else {
			ss[0] = "0" + Integer.parseInt(device_sn.substring(0, 2), 16) + "";
		}
		if (Integer.parseInt(device_sn.substring(2, 4), 16) > 10) {
			ss[1] = Integer.parseInt(device_sn.substring(2, 4), 16) + "";
		} else {
			ss[1] = "0" + Integer.parseInt(device_sn.substring(2, 4), 16);
		}
		if (Integer.parseInt(device_sn.substring(4, 6), 16) > 10) {
			ss[2] = Integer.parseInt(device_sn.substring(4, 6), 16) + "";
		} else {
			ss[2] = "0" + Integer.parseInt(device_sn.substring(4, 6), 16);
		}
		if (Integer.parseInt(device_sn.substring(6, 10), 16) > 1000) {
			ss[3] = Integer.parseInt(device_sn.substring(6, 10), 16) + "";
		} else {
			ss[3] = "0" + Integer.parseInt(device_sn.substring(6, 10), 16);
		}
		return ss;

	}

	public static String parseDateHex(String date) {
		String[] string = sub2String(date);
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < string.length; i++) {
			if (Integer.toHexString(Integer.parseInt(string[i])).length() < 2) {
				s.append("0").append(
						Integer.toHexString(Integer.parseInt(string[i])));
			} else {
				s.append(Integer.toHexString(Integer.parseInt(string[i])));
			}

		}
		return s.toString();

	}

	/**
	 * 将字符串转换为每两个一组
	 * 
	 * @param str
	 * @return 返回数组
	 */
	public static String[] sub2String(String str) {
		int length = str.length();
		String[] strs = null;
		if (str != null) {
			if (length % 2 == 0) {
				strs = new String[length / 2];
				for (int i = 0; i < length / 2; i++) {
					strs[i] = str.substring(i * 2, i * 2 + 2);
				}
			} else {
				strs = new String[length / 2 + 1];
				for (int i = 0; i < length / 2 + 1; i++) {
					if (i < length / 2) {
						strs[i] = str.substring(i * 2, i * 2 + 2);
					} else {
						strs[i] = str.substring(i * 2, length);
					}
				}
			}
		}
		return strs;
	}
	
	
	/**
	 * 将字符串每10个一组
	 * @param str
	 * @return
	 */
	public static String[] sub5String(String str) {
		int length = str.length();
		String[] strs = null;
		if (str != null) {
			if (length % 10 == 0) {
				strs = new String[length / 10];
				for (int i = 0; i < length / 10; i++) {
					strs[i] = str.substring(i * 10, i * 10 + 10);
				}
			} 
		}
		return strs;
	}
	
	//1001130c1e rDate=
	//1601191230
	//cc800515010102520f0c0108a0001249132b27001001130c1ebe
	//cc800515010102520f0c0108a0001249132b27001001130c1ebe
	public static void main(String[] args) {
		String[] parseDate = parseDate("1001130c1e");
		for (int i = 0; i < parseDate.length; i++) {
			System.out.println(parseDate[i]);
		}
	}
}
