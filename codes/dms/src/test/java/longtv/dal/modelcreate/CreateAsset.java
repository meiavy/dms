package longtv.dal.modelcreate;

import junit.framework.TestCase;
import longtv.dal.Asset;
import longtv.dal.DataStore;
import longtv.dal.MongoDataStore;

public class CreateAsset extends TestCase {
	
	public void testCreateModel()
	{
		DataStore ds=new MongoDataStore();

		for(int i=0;i<100;i++)
		{
			Asset model=new Asset();
			model.setAsset_id("asset_id"+i);
			model.setAsset_name(""+i);
			model.setAsset_provider(""+i);
			model.setAsset_duration((long)i);
			ds.save(model);
		}
	}
}
