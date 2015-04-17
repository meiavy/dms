package longtv.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class DateTimeHelper
{
    public static String fromSyncUpdatedTime(Date time)
    {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime=df.format(time);
        return strTime;
    }
    
    public static Date fromString(String strDate)
    {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try
        {
            date = format.parse(strDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }
    
    public static Date fromString(String strDate,String format1)
    {
        DateFormat format = new SimpleDateFormat(format1);
        Date date = null;
        try
        {
            date = format.parse(strDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }
    
    public static String formatDate(Date date,String formatString)
    {
        DateFormat format = new SimpleDateFormat(formatString);
        return format.format(date);
    }

	public static String getSixDayAgo(Date current) {
		// TODO Auto-generated method stub
		Calendar c=Calendar.getInstance();
		c.setTime(current);
		c.add(Calendar.DAY_OF_MONTH, -6);
		return formatDate(c.getTime(),"yyyy-MM-dd");
	}
	
	public static String getYesterday(Date current) {
		// TODO Auto-generated method stub
		Calendar c=Calendar.getInstance();
		c.setTime(current);
		c.add(Calendar.DAY_OF_MONTH, -1);
		return formatDate(c.getTime(),"yyyy-MM-dd");
	}
	
	public static String truncateToDay(Date date)
	{
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return formatDate(c.getTime(),"yyyy-MM-dd");
	}

	public static String truncateToHour(Date date) {
		// TODO Auto-generated method stub
		
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return formatDate(c.getTime(),"yyyy-MM-dd HH");	

	}

	public static String getTomorrow(Date fromString) {
		// TODO Auto-generated method stub
		Calendar c=Calendar.getInstance();
		c.setTime(fromString);
		c.add(Calendar.DAY_OF_MONTH, 1);
		return formatDate(c.getTime(),"yyyy-MM-dd");
	}

	public static String addDate(Date date, int i) {
		// TODO Auto-generated method stub
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, i);
		return formatDate(c.getTime(),"yyyy-MM-dd");	
	}
    
    
}
