package com.yancey.manager.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

  public static final String DATE_PATTEN_YYMMDD          = "yyyyMMdd";
  public static final String DATE_PATTEN_YY_MM_DD        = "yyyy-MM-dd";
  public static final String DATE_FILE_PATTEN            = "yyyy/MM/dd";
  public static final String DATE_PATTEN_YY_MM_DD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
  public static final String DATE_PATTEN_HHMM            = "HH:mm";

  public static String getPreviousDateStr() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -1);
    return new SimpleDateFormat(DATE_PATTEN_YYMMDD).format(calendar.getTime());
  }
  /**
   * 获取前一天日期
   * 
   * @return
   */
  public static Date getPreviousDate() {
    String yestoday = getPreviousDateStr();
    return stringToDate(yestoday, DATE_PATTEN_YYMMDD);
  }

  public static String getCurrentDateStr() {
    Calendar calendar = Calendar.getInstance();
    return new SimpleDateFormat(DATE_PATTEN_YYMMDD).format(calendar.getTime());
  }

  public static String getCurrentDateFilePath() {
    Calendar calendar = Calendar.getInstance();
    return new SimpleDateFormat(DATE_FILE_PATTEN).format(calendar.getTime());
  }

  /**
   * 获取当天的日期
   * 
   * @return
   */
  public static Date getCurrentDate() {
    String yestoday = getCurrentDateStr();
    return stringToDate(yestoday, DATE_PATTEN_YYMMDD);
  }
  /**
   * 将String类型的日期转为date类型
   * 
   * @param date
   * @param patten
   * @return
   */
  public static Date stringToDate(String date, String patten) {
    SimpleDateFormat sf = new SimpleDateFormat(patten);
    Date d = null;
    try {
      d = sf.parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return d;
  }

  public static void main(String[] args) {
    // System.out.println(getCurrentDate());
    System.out.println(transferDateToString(new Date(), DATE_PATTEN_HHMM));
  }

  public static String transferDateToString(Date date, String pattern) {
    if (date == null)
      return null;
    SimpleDateFormat dateFormate = new SimpleDateFormat(pattern);
    return dateFormate.format(date);
  }

  // ///////////////////////////////////////////////////////////////////////////////////////////

  public static String long2StrDate(String date) {
    if ((date == null) || (date.equals(""))) {
      return "";
    }
    return long2StrDate(Long.valueOf(date));
  }

  public static String int2StrDate(Integer date) {
    if (date == null)
      return "";
    return long2StrDate(Long.valueOf(date.intValue()));
  }

  public static String long2StrDate(Number date) {
    String fmDate = new String();
    if (date == null) {
      fmDate = "";
    } else {
      fmDate = date.toString();
      String year = "";
      String month = "";
      String day = "";
      String hour = "";
      String minute = "";

      if (fmDate.length() < 8) {
        fmDate = "";
      }
      if (fmDate.length() >= 8) {
        year = fmDate.substring(0, 4);
        month = fmDate.substring(4, 6);
        day = fmDate.substring(6, 8);
        fmDate = year + "/" + month + "/" + day;
      }
      if (date.toString().length() >= 12) {
        hour = date.toString().substring(8, 10);
        minute = date.toString().substring(10, 12);
        fmDate = fmDate + " " + hour + ":" + minute;
      }
      if (date.toString().length() == 14) {
        fmDate = fmDate + ":" + date.toString().substring(12, 14);
      }
    }
    return fmDate;
  }
  public static String int2StrOnlyDate(Number date) {
    String fmDate = new String();
    if (date == null) {
      fmDate = "";
    } else {
      String year = "";
      String month = "";
      String day = "";
      fmDate = date.toString();
      if (fmDate.length() < 8) {
        fmDate = "";
      }
      if (fmDate.length() >= 8) {
        year = fmDate.substring(0, 4);
        month = fmDate.substring(4, 6);
        day = fmDate.substring(6, 8);
        fmDate = year + "/" + month + "/" + day;
      }
    }
    return fmDate;
  }
  public static String int2StrCnDate(Integer date) {
    if (date == null)
      return "";
    return long2StrCnDate(Long.valueOf(date.intValue()));
  }

  public static String long2StrCnDate(Long date) {
    String fmDate = new String();
    if (date == null) {
      fmDate = "";
    } else {
      fmDate = date.toString();
      String year = "";
      String month = "";
      String day = "";
      String hour = "";
      String minute = "";

      if (fmDate.length() < 8) {
        fmDate = "";
      }
      if (fmDate.length() >= 8) {
        year = fmDate.substring(0, 4);
        month = fmDate.substring(4, 6);
        day = fmDate.substring(6, 8);
        fmDate = year + "年" + month + "月" + day + "日";
      }
      if (date.toString().length() >= 10) {
        hour = date.toString().substring(8, 10);
        fmDate = fmDate + hour + "时";
      }

      if (date.toString().length() >= 12) {
        minute = date.toString().substring(10, 12);
        fmDate = fmDate + minute + "分";
      }

      if (date.toString().length() == 14) {
        fmDate = fmDate + date.toString().substring(12, 14) + "秒";
      }
    }
    return fmDate;
  }

  public static String long2StrCnDate(Number date) {
    String fmDate = new String();
    if (date == null) {
      fmDate = "";
    } else {
      fmDate = String.valueOf(date.longValue());
      String year = "";
      String month = "";
      String day = "";
      String hour = "";
      String minute = "";

      if (fmDate.length() < 8) {
        fmDate = "";
      }
      if (fmDate.length() >= 8) {
        year = fmDate.substring(0, 4);
        month = fmDate.substring(4, 6);
        day = fmDate.substring(6, 8);
        fmDate = year + "年" + month + "月" + day + "日";
      }
      if (date.toString().length() >= 12) {
        hour = date.toString().substring(8, 10);
        minute = date.toString().substring(10, 12);
        fmDate = fmDate + hour + "时" + minute + "分";
      }
      if (date.toString().length() == 14) {
        fmDate = fmDate + date.toString().substring(12, 14) + "秒";
      }
    }
    return fmDate;
  }

  public static String long2StrCnDate(Number date, int length) {
    if (date != null) {
      Long l = Long.valueOf(String.valueOf(date.longValue()).substring(0, length));
      return long2StrCnDate(l);
    }
    return null;
  }

  public static Integer str2IntDate(String strFmDate) {
    Long date = str2LongDate(strFmDate);
    if (date == null)
      return null;
    return Integer.valueOf(date.intValue());
  }

  public static Long str2LongDate(String strFmDate) {
    if ((strFmDate == null) || (strFmDate.length() == 0)) {
      return null;
    }
    Long longDate = new Long(0L);
    if (strFmDate.matches("^([12]\\d{3}/[01]\\d/[0123]\\d)$")) {
      longDate = Long.valueOf(strFmDate.replaceAll("/", ""));
    }
    if (strFmDate.matches("^([12]\\d{3}/[01]\\d/[0123]\\d\\s[012]\\d:[0-5]\\d)$")) {
      strFmDate = strFmDate.replaceAll("/", "").replaceAll(":", "").replaceAll("\\s", "");
      longDate = Long.valueOf(strFmDate);
    }
    if (strFmDate.matches("^([12]\\d{3}/[01]\\d/[0123]\\d\\s[012]\\d:[0-5]\\d:[0-5]\\d)$")) {
      strFmDate = strFmDate.replaceAll("/", "").replaceAll(":", "").replaceAll("\\s", "");
      longDate = Long.valueOf(strFmDate);
    }
    return longDate;
  }

  public static String getCurrentDateView() {
    Calendar cldCurrent = Calendar.getInstance();

    String strYear = String.valueOf(cldCurrent.get(1));
    String strMonth = String.valueOf(cldCurrent.get(2) + 1);
    String strDate = String.valueOf(cldCurrent.get(5));

    if (strMonth.length() < 2) {
      strMonth = "0" + strMonth;
    }
    if (strDate.length() < 2) {
      strDate = "0" + strDate;
    }

    String StrCurrentCalendar = strYear + "/" + strMonth + "/" + strDate;
    return StrCurrentCalendar;
  }

  public static String getCurrentDateTimeView() {
    Calendar cldCurrent = Calendar.getInstance();

    String strYear = String.valueOf(cldCurrent.get(1));
    String strMonth = String.valueOf(cldCurrent.get(2) + 1);
    String strDate = String.valueOf(cldCurrent.get(5));
    String srtHours = String.valueOf(cldCurrent.get(11));
    String strMinute = String.valueOf(cldCurrent.get(12));

    if (strMonth.length() < 2) {
      strMonth = "0" + strMonth;
    }
    if (strDate.length() < 2) {
      strDate = "0" + strDate;
    }
    if (srtHours.length() < 2) {
      srtHours = "0" + srtHours;
    }
    if (strMinute.length() < 2) {
      strMinute = "0" + strMinute;
    }

    String StrCurrentCalendar = strYear + "/" + strMonth + "/" + strDate + " " + srtHours + ":" + strMinute;
    return StrCurrentCalendar;
  }

  public static Integer getIntCurrDate() {
    Calendar cldCurrent = Calendar.getInstance();

    String strYear = String.valueOf(cldCurrent.get(1));
    String strMonth = String.valueOf(cldCurrent.get(2) + 1);
    String strDate = String.valueOf(cldCurrent.get(5));

    if (strMonth.length() < 2) {
      strMonth = "0" + strMonth;
    }
    if (strDate.length() < 2) {
      strDate = "0" + strDate;
    }
    return Integer.valueOf(strYear + strMonth + strDate);
  }

  public static Integer getIntFirstDayOfMonth() {
    Calendar cldCurrent = Calendar.getInstance();

    String strYear = String.valueOf(cldCurrent.get(1));
    String strMonth = String.valueOf(cldCurrent.get(2) + 1);

    if (strMonth.length() < 2) {
      strMonth = "0" + strMonth;
    }
    return Integer.valueOf(strYear + strMonth + "01");
  }

  public static Integer getIntCurrYear() {
    Calendar cldCurrent = Calendar.getInstance();

    String strYear = String.valueOf(cldCurrent.get(1));
    return Integer.valueOf(strYear);
  }

  public static Long getLongCurrDateTime() {
    Calendar cldCurrent = Calendar.getInstance();

    String strYear = String.valueOf(cldCurrent.get(1));
    String strMonth = String.valueOf(cldCurrent.get(2) + 1);
    String strDate = String.valueOf(cldCurrent.get(5));
    String srtHours = String.valueOf(cldCurrent.get(11));
    String strMinute = String.valueOf(cldCurrent.get(12));

    if (strMonth.length() < 2) {
      strMonth = "0" + strMonth;
    }
    if (strDate.length() < 2) {
      strDate = "0" + strDate;
    }
    if (srtHours.length() < 2) {
      srtHours = "0" + srtHours;
    }
    if (strMinute.length() < 2) {
      strMinute = "0" + strMinute;
    }
    return Long.valueOf(strYear + strMonth + strDate + srtHours + strMinute);
  }

  public static Long getLongCurrDateTime8() {
    Calendar cldCurrent = Calendar.getInstance();

    String strYear = String.valueOf(cldCurrent.get(1));
    String strMonth = String.valueOf(cldCurrent.get(2) + 1);
    String strDate = String.valueOf(cldCurrent.get(5));
    String srtHours = String.valueOf(cldCurrent.get(11));
    String strMinute = String.valueOf(cldCurrent.get(12));

    if (strMonth.length() < 2) {
      strMonth = "0" + strMonth;
    }
    if (strDate.length() < 2) {
      strDate = "0" + strDate;
    }
    if (srtHours.length() < 2) {
      srtHours = "0" + srtHours;
    }
    if (strMinute.length() < 2) {
      strMinute = "0" + strMinute;
    }
    return Long.valueOf(strYear + strMonth + strDate);
  }

  public static String getCurrentDateTime() {
    return getDateTime(0, 0);
  }

  public static String getDateTime(int month, int date) {
    Calendar calendar = Calendar.getInstance();
    if (month != 0) {
      calendar.add(2, month);
    }
    if (date != 0) {
      calendar.add(5, date);
    }

    String strYear = String.valueOf(calendar.get(1));
    String strMonth = String.valueOf(calendar.get(2) + 1);
    String strDate = String.valueOf(calendar.get(5));
    String srtHours = String.valueOf(calendar.get(11));
    String strMinute = String.valueOf(calendar.get(12));

    if (strMonth.length() < 2) {
      strMonth = "0" + strMonth;
    }
    if (strDate.length() < 2) {
      strDate = "0" + strDate;
    }
    if (srtHours.length() < 2) {
      srtHours = "0" + srtHours;
    }
    if (strMinute.length() < 2) {
      strMinute = "0" + strMinute;
    }
    return strYear + strMonth + strDate + srtHours + strMinute;
  }

  public static String getCurrentYearFirstDate() {
    Calendar calendar = Calendar.getInstance();

    String strYear = String.valueOf(calendar.get(1));

    return strYear + "01" + "01" + "00" + "00";
  }

  public static Long getLongCurrDateTime14() {
    return Long.valueOf(formateCalendar(Calendar.getInstance(), "yyyyMMddHHmmss"));
  }

  public static Long getLongCurrDateTime12() {
    return Long.valueOf(formateCalendar(Calendar.getInstance(), "yyyyMMddHHmm"));
  }

  public static Long transferDateToLong(Date date) {
    if (date == null)
      return null;
    SimpleDateFormat dateFormate = new SimpleDateFormat("yyyyMMddHHmmss");
    return Long.valueOf(dateFormate.format(date));
  }

  public static String formateCalendar(Calendar calendar, String format) {
    if (calendar == null)
      return null;
    SimpleDateFormat dateFormate = new SimpleDateFormat(format);
    return dateFormate.format(calendar.getTime());
  }

  public static String dateFormateStr(String strDate) {
    if (strDate == null)
      return "";
    String fmDate = "";
    String year = "";
    String month = "";
    String day = "";
    if (strDate.length() >= 8) {
      year = strDate.substring(0, 4);
      month = strDate.substring(4, 6);
      day = strDate.substring(6, 8);
      fmDate = year + "-" + month + "-" + day;
    }
    return fmDate;
  }

  public static Calendar long2Calendar(Long time) {
    Calendar calendar = null;
    if (time == null) {
      calendar = Calendar.getInstance();
    } else {
      String strTime = String.valueOf(time);
      int year = 0;
      int month = 0;
      int day = 0;
      int hour = 0;
      int minute = 0;
      int sec = 0;
      if (strTime.length() < 8) {
      }
      if (strTime.length() >= 8) {
        year = Integer.valueOf(strTime.substring(0, 4)).intValue();
        month = Integer.valueOf(strTime.substring(4, 6)).intValue() - 1;
        day = Integer.valueOf(strTime.substring(6, 8)).intValue();
      }
      if (strTime.length() >= 10) {
        hour = Integer.valueOf(strTime.substring(8, 10)).intValue();
      }
      if (strTime.length() >= 12) {
        minute = Integer.valueOf(strTime.substring(10, 12)).intValue();
      }
      if (strTime.length() >= 14) {
        sec = Integer.valueOf(strTime.substring(12, 14)).intValue();
      }
      calendar = new GregorianCalendar(year, month, day, hour, minute, sec);
    }
    return calendar;
  }

  public static long calcTimeAddOfDay(long time, double days) {
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");

    Date date1 = new Date();
    try {
      date1 = format.parse(String.valueOf(time));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    int addDay = (int) (days * 24.0D);
    long Time = date1.getTime() / 1000L + 3600 * addDay;

    date1.setTime(Time * 1000L);

    String mydate = format.format(date1);

    return Long.parseLong(mydate);
  }

  public static long getTimeSubtractOfDay(long time, int days) {
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");

    Date date1 = new Date();
    try {
      date1 = format.parse(String.valueOf(time));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    int subtractDay = days * 24;
    long Time = date1.getTime() / 1000L - 3600 * subtractDay;

    date1.setTime(Time * 1000L);

    String mydate = format.format(date1);

    return Long.parseLong(mydate);
  }

  public static long getDateToNow(int number, int type, int ws) {
    Long resultLong = null;
    Calendar cal = Calendar.getInstance();
    Date date = new Date();
    cal.setTime(date);
    if (type == 1)
      cal.add(1, number);
    else if (type == 2)
      cal.add(2, number);
    else if (type == 3) {
      cal.add(5, number);
    }
    resultLong = transferDateToLong(cal.getTime());
    if (ws == 8) {
      resultLong = Long.valueOf(resultLong.longValue() / 1000000L);
    }
    return resultLong.longValue();
  }

  public static String getLongTime(Number date) {
    String fmDate = new String();
    if (date == null) {
      fmDate = "";
    } else {
      fmDate = String.valueOf(date.longValue());
      String hour = "";
      String minute = "";
      String seconds = "";

      if (fmDate.length() < 14) {
        fmDate = "";
      }
      if (fmDate.length() == 14) {
        hour = fmDate.substring(8, 10);
        minute = fmDate.substring(10, 12);
        seconds = fmDate.substring(12, 14);
        fmDate = hour + ":" + minute + ":" + seconds;
      }
    }
    return fmDate;
  }

  public static Long getMonthBegin(Long time) {
    Calendar cal = long2Calendar(time);
    int year = cal.get(1);
    int month = cal.get(2);
    cal.set(year, month, 1);
    return calendarToLong8(cal);
  }

  public static Long calendarToLong8(Calendar cal) {
    int year = cal.get(1);
    int month = cal.get(2) + 1;
    int date = cal.get(5);
    String strMonth = month < 10 ? "0" + month : String.valueOf(month);
    String strDate = date < 10 ? "0" + date : String.valueOf(date);

    return Long.valueOf(Long.parseLong(year + strMonth + strDate));
  }

  public static Long getMonthEnd(Long time) {
    Calendar cal = long2Calendar(getMonthBegin(time));
    cal.add(2, 1);
    cal.add(6, -1);
    return calendarToLong8(cal);
  }
}