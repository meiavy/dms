package longtv.dal.modelcreate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;
import longtv.dal.DataStore;
import longtv.dal.LiveLog;
import longtv.dal.MongoDataStore;
import longtv.utils.DateTimeHelper;

public class CreateLiveLog extends TestCase {
	
	private Random rand=new Random();
	
	public void testCreateModel()
	{
		
		
		final String[] dateList=new String[]{"2015-01-01","2015-01-02","2015-01-03"};

		Date start=new Date();
		
		List<Thread> listT=new ArrayList<Thread>();
		
		for(int i=0;i<10000;i=i+1000)
		{
			
			Thread t=new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					DataStore ds=new MongoDataStore();
					for(int j=0;j<1000;j++)
					{
						LiveLog model=new LiveLog();
						model.setAsset_id("asset_id"+j%1000);
						model.setCard_number(""+j);
						model.setProgram_name("program"+j);
						model.setStart_time(dateList[rand.nextInt(3)]);
						model.setEnd_time("2015-01-05");
						model.setArea_id("area"+j);
						ds.save(model);
						
						if(j%100==0)
						{
							System.out.println(Thread.currentThread().getId()+" "+j);
						}
					}
					

					
				}
			});
			
			
			listT.add(t);
			
			t.start();
			
		}
		
		for(Thread t : listT)
		{
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Date end=new Date();
		long l=end.getTime()-start.getTime();
		System.out.println(l/1000);
	}
	
}
