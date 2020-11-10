package com.demo.utils.tools;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xuezy
 * @description 日期工具类
 * @date 2020/11/10 12:05
 */
public class DateUtils {

	/**
	 * 获取Timestamp类型时间差，格式：xx小时xx分钟
	 * @param endTime 结束页面
	 * @param startTime 开始时间
	 * @return
	 */
	public static String getTimeDifference(Timestamp endTime, Timestamp startTime) {
		StringBuffer sf = new StringBuffer("");
		long t1 = endTime.getTime();
		long t2 = startTime.getTime();
		int hours=(int) ((t1 - t2)/(1000*60*60));
		int minutes=(int) (((t1 - t2)/1000-hours*(60*60))/60);
//        int second=(int) ((t1 - t2)/1000-hours*(60*60)-minutes*60);
		if(hours != 0) {
			sf.append(hours).append("小时");
		}
		if(minutes != 0) {
			sf.append(minutes).append("分钟");
		}
		return sf.toString();
	}

	/**
	 * 获取Date类型时间差，格式：xx小时xx分钟
	 * @param endTime 结束页面
	 * @param startTime 开始时间
	 * @return
	 */
	public static String getTimeDifference(Date endTime, Date startTime) {
		StringBuffer sf = new StringBuffer("");
		long t1 = endTime.getTime();
		long t2 = startTime.getTime();
		int hours=(int) ((t1 - t2)/(1000*60*60));
		int minutes=(int) (((t1 - t2)/1000-hours*(60*60))/60);
//        int second=(int) ((t1 - t2)/1000-hours*(60*60)-minutes*60);
		if(hours != 0) {
			sf.append(hours).append("小时");
		}
		if(minutes != 0) {
			sf.append(minutes).append("分钟");
		}
		return sf.toString();
	}

	/***
	 * 设定一个日期时间，加几分钟（小时或者天）后得到新的日期
	 * @param dateTime 设定的日期
	 * @param type 1.秒  2.分钟   3.小时  4.天   5.月   6.年
	 * @param params 时长 （可以是负数）
	 * @return
	 */
	public static Date dateAddTimes(Date dateTime, int type, int params) {
		if(dateTime == null) {
			return null;
		}
		Calendar ca = Calendar.getInstance();
		ca.setTime(dateTime);
		switch(type) {
			// + 秒
			case 1:
				ca.add(Calendar.SECOND, params);
				break;
			// + 分钟
			case 2:
				ca.add(Calendar.MINUTE, params);
				break;
			// + 小时
			case 3:
				ca.add(Calendar.HOUR, params);
				break;
			// + 天
			case 4:
				ca.add(Calendar.DATE, params);
				break;
			// + 月
			case 5:
				ca.add(Calendar.MONTH, params);
				break;
			// + 年
			case 6:
				ca.add(Calendar.YEAR, params);
				break;
			default:
				break;
		}
		return ca.getTime();
	}

	public static void main(String[] args) throws ParseException {
		Timestamp time = Timestamp.valueOf("2020-11-10 18:42:29");
		Timestamp time2 = Timestamp.valueOf("2020-10-30 17:52:29");
		String msg = getTimeDifference(time, time2);
		System.out.println(msg);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse("2020-11-10 18:42:29");
		Date date2 = simpleDateFormat.parse("2020-11-10 17:52:29");
		String msg2 = getTimeDifference(date, date2);
		System.out.println(msg2);

		System.out.println(dateAddTimes(date, 1, 12));
		System.out.println(dateAddTimes(date, 2, 12));
		System.out.println(dateAddTimes(date, 3, 12));
		System.out.println(dateAddTimes(date, 4, 12));
		System.out.println(dateAddTimes(date, 5, 12));
		System.out.println(dateAddTimes(date, 6, 12));
	}

}
