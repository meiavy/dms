package longtv.utils;

import org.json.JSONObject;

import junit.framework.TestCase;

public class JSONHelperTest extends TestCase {
	public void testCreateBlockIndicator()
	{
		String myJson="{\"usercount\":\"200\",\"date\":\"2015-01-01\",\"rate\":\"+100.00%\"}";
		JSONObject json1=new JSONObject(myJson);
		String strJson=JSONHelper.createBlockIndicator(200,100, "2015-01-01");
		JSONObject json2=new JSONObject(strJson);
		assertEquals(json1.toString(), json2.toString());
	}
}
