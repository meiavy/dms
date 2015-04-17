package longtv.dal.modelcreate;

import java.util.Date;

import junit.framework.TestCase;
import longtv.dal.DataStore;
import longtv.dal.EventLog;
import longtv.dal.MongoDataStore;

public class CreateEventLog extends TestCase {
	
	public void testCreateModel()
	{
		DataStore ds=new MongoDataStore();

		for(int i=0;i<100;i++)
		{
			EventLog model=new EventLog();
			model.setEvent_id(""+i);
			model.setEvent_type("vod");
			model.setDate_time(new Date());
			model.setCard_number(""+i);

			ds.save(model);
		}
	}
}
