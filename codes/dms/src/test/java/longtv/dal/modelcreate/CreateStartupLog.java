package longtv.dal.modelcreate;

import java.util.Date;

import junit.framework.TestCase;
import longtv.dal.DataStore;
import longtv.dal.MongoDataStore;
import longtv.dal.StartupLog;

public class CreateStartupLog extends TestCase {
	
	public void testCreateModel()
	{
		DataStore ds=new MongoDataStore();

		for(int i=0;i<100;i++)
		{
			StartupLog model=new StartupLog();
			model.setCard_number("card"+i);
			model.setDate_time(new Date());
			model.setArea_id("area"+i);
			ds.save(model);
		}
	}
}
