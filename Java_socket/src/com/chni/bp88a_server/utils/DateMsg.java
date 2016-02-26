package com.chni.bp88a_server.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateMsg {
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 获得当前时间
	 * 
	 * @author pany
	 * @param index
	 * @return
	 */
	public static String getNowDate(int index) {
		if (index == 0) {
			return sdf1.format(new Date());
		} else if (index == 1) {
			return sdf2.format(new Date());
		}
		return "";
	}

	/**
	 * 计算两个日期之间相距多少天
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int getBetweenTime1AndTime2(String begin, String end) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings("unused")
		Calendar calendar = Calendar.getInstance();
		long to = 0;
		long from = 0;
		int timeNum = 0;
		try {
			to = df.parse(begin.toString()).getTime();
			from = df.parse(end.toString()).getTime();
			timeNum = (int) ((from - to) / (1000 * 60 * 60 * 24));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timeNum;
	}

	/**
	 * 得到当前时间的具体的年月日周
	 * 
	 * @author pany
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static Map<String, Integer> getDateMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Calendar can = Calendar.getInstance();
		int year = can.get(Calendar.YEAR);
		int month = can.get(Calendar.MONTH) + 1;
		int day = can.get(Calendar.DAY_OF_MONTH);
		int week = can.get(can.DAY_OF_WEEK) - can.getFirstDayOfWeek();
		map.put("year", year);
		map.put("month", month);
		map.put("day", day);
		map.put("week", week);
		return map;
	}

	/**
	 * 
	 *传一个日期判断为星期几
	 * 
	 * @param data
	 * @return
	 */
	public static String getweek(String data) {

		Calendar can = Calendar.getInstance();
		String w[] = data.split("-");
		int year = Integer.parseInt(w[0]);
		int mon = Integer.parseInt(w[1]);
		int day = Integer.parseInt(w[2]);
		// System.out.println(w[0]+""+w[1]+""+w[2]);

		can.set(year, mon - 1, day);
		int num = can.get(Calendar.DAY_OF_WEEK) - 1;
		String[] str = { "7", "1", "2", "3", "4", "5", "6" };
		System.out.println("num" + num);
		// System.out.println("week"+str[num]);
		return str[num];

	}

	/**
	 * 得到几天后的时间
	 */

	public static String getDateAfter(String d, int day) {
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar now = Calendar.getInstance();
		Date date = StringToDate(d, "yyyy-MM-dd");
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return shortSdf.format(now.getTime());
	}

	/**
	 * 得到几天前的时间
	 */

	public static String getDateBefore(String d, int day) {
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar now = Calendar.getInstance();
		Date date = StringToDate(d, "yyyy-MM-dd");
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return shortSdf.format(now.getTime());
	}
/**
 * 得到前几天"yyyy-MM-dd HH:mm:ss"

 */
	public static String getDateBeforeN(String d, int day) {
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar now = Calendar.getInstance();
		Date date = StringToDate(d, "yyyy-MM-dd HH:mm:ss");
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return shortSdf.format(now.getTime());
	}
	
	/**
	 * string类型转换成date
	 * 
	 * @author pany
	 * @param dateStr
	 * @param formatStr
	 * @return
	 */
	public static Date StringToDate(String dateStr, String formatStr) {
		DateFormat sdf = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * date转换成String
	 * 
	 * @author pany
	 * @param date
	 * @return
	 */
	public static String dateTostring(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat();
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ctime = formatter.format(date);
		return ctime;
	}

	public static void main(String[] args) {
//		long currentTimeMillis = System.currentTimeMillis();
//		String rDate = sdf3.format(new Date(currentTimeMillis));
//		rDate = rDate.substring(2, rDate.length() - 2);
//		System.err.println("测试时间："+rDate);
		System.out.println(getNowDate(1));
		System.out.println(addDate(2));
		System.out.println(handleTime("2016-01-22"));;
	}

	/**
	 * 解析时间
	 * 
	 * @param nowDate
	 * @param i
	 * @return 
	 */
	public static Date parseDate(String nowDate, int flag) {
		try {
			if (flag == 0) {
				return sdf1.parse(nowDate);
			}
			return sdf2.parse(nowDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("解析时间出错.");
	}
	/**
	 * 比较时间
	 */
	public static String getResult(String time){
		String flag="";
	 Date time1= StringToDate(time,"yyyy-MM-dd HH:mm:ss");
	 Date time2= StringToDate(getNowDate(1),"yyyy-MM-dd HH:mm:ss");	
	 Long days=time2.getTime()-time1.getTime();//86400000
	 int i=0;
	 if(days<60000){
		 return "刚刚"; 
	 }
	 if(days<3600000 && days>=60000){
	  i=Integer.valueOf(String.valueOf(days/60000));
	  return i+"分钟前";
	 }
	 if(days>=3600000 && days<86400000){
		 
     i=Integer.valueOf(String.valueOf(days/3600000)); 
		 return i+"小时前";
	 }
	 if(days>=86400000){
		 i=Integer.valueOf(String.valueOf(days/86400000)); 
		 
		if(i>=30){
			
			if((i/30)>12){	
				
			return time;
			
			}
			
			return i/30+"月前";	
		} 
		
		return i+"天前";
		 
	 }
		return flag;
	}
	
   public static String  handleTime(String entrydate){
	   String date=entrydate.trim();
	   String nowdate=sdf2.format(new Date());
	   if(date.length()==14){//20150826 10:37
		date=date+":00";
		date=date.substring(0,4)+"-"+date.substring(4,date.length());
		date=date.substring(0,7)+"-"+date.substring(7,date.length());
		return date;
		   
	   }
	   if(date.length()==10){//2015-08-26
		   date =date+" "+nowdate.trim().substring(11,nowdate.length());
		  return date;
	   }
	   if(date.length()==8){//20150826
		date=date.substring(0,4)+"-"+date.substring(4,date.length());
		date=date.substring(0,7)+"-"+date.substring(7,date.length()); 
		date=date+" "+nowdate.trim().substring(11,nowdate.length());
		return date;
	   }
	   if(date.length()==16){//2015-08-26 00:00
		   date=date+":00"; 
		   return date;
	   }
	   return nowdate;
   }
   
     public static String parseDate(String s){
    	 Date date;
    	 try {
    		 date = sdf3.parse(s);
    		 s=sdf2.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return s;
    	 
     }
	
     
     public static String addDate(int num){
 		Date date=new Date();
 		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		Calendar calendar = Calendar.getInstance();

 		//默认为系统时间加 1秒
 		calendar.setTime(date);    
 		calendar.add(Calendar.SECOND, num);    
 		String str=df.format(calendar.getTime());

 		return str;
 	}

     
    
}
