package longtv.dal.modelcreate;

import junit.framework.TestCase;
import longtv.dal.DataStore;
import longtv.dal.MongoDataStore;
import longtv.dal.Terminal;

public class CreateTerminal extends TestCase {
	
	public void testCreateModel()
	{
		DataStore ds=new MongoDataStore();

		for(int i=0;i<100;i++)
		{
			Terminal model=new Terminal();
			model.setCard_number("card"+i);
			model.setArea_code("area"+i);
			ds.save(model);
		}
	}
}
