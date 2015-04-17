package longtv.dal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sun.xml.internal.ws.api.ha.HaInfo;

import junit.framework.TestCase;
import longtv.utils.DateTimeHelper;

public class DataStoreCreateTest extends TestCase {
	
	public void testCreateUniqueIndicator()
	{
		DataStore ds=new MongoDataStore();

		for(int i=0;i<100;i++)
		{
			UniqueIndicator indicator=new UniqueIndicator();
			indicator.setMedia_id("media_id"+i);
			indicator.setMedia_type("StartAd");
			indicator.setArea_code("guangzhou");
			indicator.setTimes_slice_type("Day");
			indicator.setDate_time(DateTimeHelper.truncateToDay(new Date()));
			indicator.setUv(String.valueOf(i));
			indicator.setV1(String.valueOf(i));
			indicator.setV2(String.valueOf(i));
			indicator.setV3(String.valueOf(i));
			indicator.setV4(String.valueOf(i));
			indicator.setV5(String.valueOf(i));
			ds.save(indicator);
		}
	}
	
	public void testCreateVisitorIndicator()
	{
		DataStore ds=new MongoDataStore();

		for(int i=0;i<100;i++)
		{
			VisitorIndicator indicator=new VisitorIndicator();
			indicator.setMedia_id("media_id"+i);
			indicator.setMedia_type("StartAd");
			indicator.setArea_code("guangzhou");
			indicator.setDate_time(DateTimeHelper.truncateToHour(new Date()));
			indicator.setVv(String.valueOf(i*100));
			indicator.setVd(String.valueOf(i*1000));
			ds.save(indicator);
		}
	}
	
	public void testCreateMedia()
	{
		DataStore ds=new MongoDataStore();

		for(int i=0;i<100;i++)
		{
			Asset media=new Asset();
			
			media.setAsset_id("media_id"+i);
			media.setAsset_name("开机广告");
			media.setAsset_provider("guizhouguandian");
			ds.save(media);
		}
	}
	
	public void testCreateArea()
	{
		DataStore ds=new MongoDataStore();

		for(int i=0;i<100;i++)
		{
			Area area=new Area();
			//area.setCode("code"+i);
			//area.setName("name"+i);
			ds.save(area);
		}
	}
	
}
