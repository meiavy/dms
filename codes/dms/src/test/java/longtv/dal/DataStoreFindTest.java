package longtv.dal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import longtv.utils.DateTimeHelper;
import longtv.vo.AreaVisitor;

public class DataStoreFindTest extends TestCase {

	private DataStore ds;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		ds=new MongoDataStore();
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		
	}

	public void testGetCurrentStartUsers()
	{
		Date today=new Date();
		int todayIndicator=ds.getMediaTypeReach000("StartAd",DateTimeHelper.truncateToDay(today));
		int yesterdayIndicator=ds.getMediaTypeReach000("StartAd",DateTimeHelper.getYesterday(today));

	}
	
	public void testGetCurrentOnDemandUsers()
	{
		Date today=new Date();
		int todayIndicator=ds.getMediaTypeReach000("Vod",DateTimeHelper.truncateToDay(today));
		int yesterdayIndicator=ds.getMediaTypeReach000("Vod",DateTimeHelper.getYesterday(today));

	}
	
	public void testGetLookBackOnDemandUsers()
	{
		Date today=new Date();
		int todayIndicator=ds.getMediaTypeReach000("Back",DateTimeHelper.truncateToDay(today));
		int yesterdayIndicator=ds.getMediaTypeReach000("Back",DateTimeHelper.getYesterday(today));

	}
	
	
	public void testGetLiveUsers()
	{
		Date today=new Date();
		int todayIndicator=ds.getMediaTypeReach000("Live",DateTimeHelper.truncateToDay(today));
		int yesterdayIndicator=ds.getMediaTypeReach000("Live",DateTimeHelper.getYesterday(today));

	}
	
	public void testGetStartAdVisitor()
	{
		//Date today=new Date();
		Map<String,Integer> result=ds.getMediaTypeVisitorGroupByArea("StartAd",DateTimeHelper.fromString("2015-04-10 00:00:00"),DateTimeHelper.fromString("2015-04-10 00:00:00"));


		List<AreaVisitor> myList=new ArrayList<AreaVisitor>();
		
		for(Map.Entry<String, Integer> entry:result.entrySet())
		{
			String areacode=entry.getKey();
			Integer visitor=entry.getValue();
			String areaname=ds.getAreaNameByCode(areacode);
			AreaVisitor av=new AreaVisitor(areacode, areaname, String.valueOf(visitor));
			myList.add(av);
			
		}
		
	}
	
	public void testGetAreaMediaTypeDayUv()
	{

		Map<String,Integer> result=ds.getAreaMediaTypeDayUv("guangzhou","StartAd","2015-04-10","2015-04-10");

	}
	
	public void testGetAreaMediaTypeDayVv()
	{
		Map<String,Integer> result=ds.getAreaMediaTypeDayVv("guangzhou","StartAd","2015-04-10","2015-04-10");
	}
	
	public void testGetAreaMediaTypeDayVd()
	{
		Map<String,Integer> result=ds.getAreaMediaTypeDayVd("guangzhou","StartAd","2015-04-10","2015-04-10");

	}
	
	public void testGetAreaMediaTypeDuration()
	{
		Integer result=ds.getAreaMediaTypeDuration("guangzhou","StartAd");

	}
}
