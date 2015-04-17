package longtv.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import junit.framework.TestCase;

public class JsonTest extends TestCase {
	public void testJSONObject()
	{
		HashMap<String, Object> m=new HashMap<String, Object>();
		m.put("aa", "aa");
		m.put("bb", "bb");
		m.put("cc", "cc");
		m.put("dd", "dd");
		JSONObject o=new JSONObject(m);
		String s=o.toString();
		assertEquals("{\"aa\":\"aa\",\"bb\":\"bb\",\"cc\":\"cc\",\"dd\":\"dd\"}", s);
	}
	
	public void testJSONArray()
	{
		List<Object> a=new ArrayList<Object>();
		a.add("aaaaa");
		a.add("bbbbb");
		a.add("ccccc");
		a.add("ddddd");
		JSONArray o=new JSONArray(a);
		String s=o.toString();
		
		assertEquals("[\"aaaaa\",\"bbbbb\",\"ccccc\",\"ddddd\"]", s);
	}
}
