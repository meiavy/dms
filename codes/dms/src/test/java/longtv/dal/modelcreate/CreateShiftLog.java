package longtv.dal.modelcreate;

import java.util.Date;

import junit.framework.TestCase;
import longtv.dal.DataStore;
import longtv.dal.MongoDataStore;
import longtv.dal.ShiftLog;

public class CreateShiftLog extends TestCase {
	
	public void testCreateModel()
	{
		DataStore ds=new MongoDataStore();

		for(int i=0;i<100;i++)
		{
			ShiftLog model=new ShiftLog();
			model.setAsset_id("asset_id"+i);
			model.setProgram_name("program"+i);
			model.setCard_number(""+i);
			model.setEnd_time(new Date());
			model.setStart_time(new Date());
			model.setArea_id("area"+i);
			ds.save(model);
		}
	}
}
