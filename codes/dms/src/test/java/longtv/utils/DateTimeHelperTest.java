package longtv.utils;

import junit.framework.TestCase;

public class DateTimeHelperTest extends TestCase {
	public void testGetYesterday()
	{
		String yesterday=DateTimeHelper.getYesterday(DateTimeHelper.fromString("2015-01-02 00:00:00"));
		assertEquals("2015-01-01", yesterday);
	}
	
	public void testTruncateToHour()
	{
		String toHour=DateTimeHelper.truncateToHour(DateTimeHelper.fromString("2015-01-02 00:00:00"));
		assertEquals("2015-01-02 00", toHour);
	}
	
	public void testGetTomorrow()
	{
		String toHour=DateTimeHelper.getTomorrow(DateTimeHelper.fromString("2015-01-02 00:00:00"));
		assertEquals("2015-01-03", toHour);
	}
}
