package longtv.dal.modelcreate;

import java.util.Date;

import junit.framework.TestCase;
import longtv.dal.DataStore;
import longtv.dal.EpgLog;
import longtv.dal.MongoDataStore;
import longtv.dal.EpgLog;
import longtv.utils.DateTimeHelper;

public class CreateEpgLog extends TestCase {
	
	public void testCreateModel()
	{
		DataStore ds=new MongoDataStore();

		for(int i=0;i<100;i++)
		{
			EpgLog model=new EpgLog();
			model.setTs_id("ts_id"+i);
			model.setProgram_name("program"+i);
			model.setOn_id(""+i);
			model.setChannel_id(""+i);
			model.setDate_time(DateTimeHelper.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			ds.save(model);
		}
	}
}
