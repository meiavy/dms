package longtv.utils;

import java.util.HashMap;
import java.util.Random;

import org.json.JSONObject;

public class JSONHelper {

	private static Random rand=new Random();
	public static String createBlockIndicator(int todayUsercount,int yesterdayUsercount,String date)
	{
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("usercount", String.valueOf(1000+rand.nextInt(1000)));
		map.put("date", date);
		
		float diff=rand.nextInt(1000);
		float rate=diff/1000;
		
		String strRate=String.format("%+.2f%%",rate*100);
		map.put("rate", strRate);
		JSONObject json=new JSONObject(map);
		return json.toString();
		
		
		/*
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("usercount", String.valueOf(todayUsercount));
		map.put("date", date);
		
		float diff=todayUsercount-yesterdayUsercount;
		float rate=diff/yesterdayUsercount;
		
		String strRate=String.format("%+.2f%%",rate*100);
		map.put("rate", strRate);
		JSONObject json=new JSONObject(map);
		return json.toString();*/
	}
	
	
	
}
