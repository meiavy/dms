package longtv.controller;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class HomeControllerTest extends TestCase {

	public void testToJson()
	{
		HomeController c=new HomeController();
		
		Map<String,Integer> mapLive=new HashMap<String,Integer>();
		mapLive.put("2015-01-01", 100);
		mapLive.put("2015-01-02", 100);
		mapLive.put("2015-01-03", 100);
		
		Map<String,Integer> mapVod=new HashMap<String,Integer>();
		mapVod.put("2015-01-01", 200);
		mapVod.put("2015-01-02", 200);
		mapVod.put("2015-01-03", 200);
		Map<String,Integer> mapBack=new HashMap<String,Integer>();
		mapBack.put("2015-01-01", 300);
		mapBack.put("2015-01-02", 400);
		mapBack.put("2015-01-03", 500);
		
		String json=(String) c.toJson(mapLive, mapVod, mapBack);
		
		int a=0;
		
	}
	
}
