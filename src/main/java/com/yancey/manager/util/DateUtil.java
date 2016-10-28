
package com.yancey.manager.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

public class DateUtil {

	public static String addOneDay(String date){
		if(StringUtils.isBlank(date)){
			return null;
		}
		try {
			return DateUtils.parseDate(date + " 23:59:59", new String[]{"yyyy-MM-dd HH:mm:ss"}).toString();
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date addOneDay(Date date){
		if(null==date){
			return null;
		}
		date.setHours(23);
		date.setMinutes(59);
		date.setSeconds(59);
		return date;
	}
}
