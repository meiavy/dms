package longtv.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import longtv.dal.Area;
import longtv.dal.DataStore;
import longtv.dal.MongoDataStore;
import longtv.utils.DateTimeHelper;
import longtv.utils.JSONHelper;
import longtv.vo.DateRate;
import longtv.vo.DayPlayTime;
import longtv.vo.MediaRanking;
import longtv.vo.NameValue;
import longtv.vo.Top3Rtg100;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	private static Random rand = new Random();

	@RequestMapping(value = "/getCurrentStartUsers", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object getCurrentStartUsers() throws IOException {
		return createBlockIndicator("StartAd");
	}

	private String createBlockIndicator(String mediaType) {
		DataStore ds = new MongoDataStore();
		Date today = new Date();
		int todayIndicator = ds.getMediaTypeReach000(mediaType,
				DateTimeHelper.truncateToDay(today));
		int yesterdayIndicator = ds.getMediaTypeReach000(mediaType,
				DateTimeHelper.getYesterday(today));

		return JSONHelper.createBlockIndicator(todayIndicator,
				yesterdayIndicator, DateTimeHelper.truncateToDay(today));
	}

	@RequestMapping(value = "/getCurrentOnDemandUsers", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object getCurrentOnDemandUsers() throws IOException {
		return createBlockIndicator("Vod");
	}

	@RequestMapping(value = "/getLookBackOnDemandUsers", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object getLookBackOnDemandUsers() throws IOException {
		return createBlockIndicator("Back");
	}

	@RequestMapping(value = "/getLiveUsers", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object getLiveUsers() throws IOException {
		return createBlockIndicator("Live");
	}

	@RequestMapping(value = "/getVisibility", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object getVisibility(String startDate, String endDate)
			throws IOException {
		DataStore ds = new MongoDataStore();

		// Map<String,Integer>
		// result=ds.getMediaTypeVisitorGroupByArea("StartAd",
		// DateTimeHelper.fromString(startDate,"yyyy-MM-dd"),
		// DateTimeHelper.fromString(endDate,"yyyy-MM-dd"));

		List<Area> listArea = ds.getArea();
		
		
		
		List<NameValue> listData = new ArrayList<NameValue>();
		List<NameValue> importantData = new ArrayList<NameValue>();
		Map<String, List<String>> geo = new HashMap<String, List<String>>();
		int i = 0;
		for (int n=0;n<30;n++) {
			
			int index=rand.nextInt(listArea.size()-1);
			Area area = listArea.get(index);
			listArea.remove(index);
			NameValue nv = new NameValue(area.getXian(),
					String.valueOf(10000 + rand.nextInt(10000)));
			listData.add(nv);
			List<String> geoList = new ArrayList<String>();
			geoList.add(area.getJingdu());
			geoList.add(area.getWeidu());
			geo.put(area.getXian(), geoList);
			if (++i % 5 == 0) {
				importantData.add(nv);
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", listData);
		map.put("geo", geo);
		map.put("importantData", importantData);

		JSONObject json = new JSONObject(map);

		return json.toString();

	}

	@RequestMapping(value = "/getRatings", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object getRatings(String areacode, String sdate, String edate,
			String dateunit, String dimension) throws IOException {

		List<DateRate> listVod = new ArrayList<DateRate>();
		// String programid, String program, String vv, String uv,
		// String vd, String users, String rankvalue, String rank
		for (int i = 0; i < 50; i++) {
			listVod.add(new DateRate(DateTimeHelper.addDate(new Date(), i),
					String.valueOf(i * 1000)));
		}

		List<DateRate> listLive = new ArrayList<DateRate>();

		for (int i = 50; i < 100; i++) {
			listLive.add(new DateRate(DateTimeHelper
					.addDate(new Date(), i - 50), String.valueOf(i * 1000)));
		}
		List<DateRate> listBack = new ArrayList<DateRate>();

		for (int i = 100; i < 150; i++) {
			listBack.add(new DateRate(DateTimeHelper.addDate(new Date(),
					i - 100), String.valueOf(i * 1000)));
		}

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("live", listLive);
		map.put("ondemeand", listVod);
		map.put("lookback", listBack);

		JSONObject json = new JSONObject(map);

		return json.toString();

		/*
		 * DataStore ds=new MongoDataStore();
		 * 
		 * 
		 * Map<String,Integer> mapLive = new HashMap<String, Integer>();
		 * Map<String,Integer> mapVod = new HashMap<String, Integer>();
		 * Map<String,Integer> mapBack = new HashMap<String, Integer>();
		 * 
		 * if(dateunit=="day") { if(dimension=="UV") {
		 * mapLive=ds.getAreaMediaTypeDayUv(areacode, "Live", sdate, edate);
		 * mapVod=ds.getAreaMediaTypeDayUv(areacode, "Vod", sdate, edate);
		 * mapBack=ds.getAreaMediaTypeDayUv(areacode, "Back", sdate, edate);
		 * 
		 * } else if(dimension=="VV") {
		 * mapLive=ds.getAreaMediaTypeDayVv(areacode, "Live", sdate, edate);
		 * mapVod=ds.getAreaMediaTypeDayVv(areacode, "Vod", sdate, edate);
		 * mapBack=ds.getAreaMediaTypeDayVv(areacode, "Back", sdate, edate);
		 * 
		 * } else if(dimension=="VD") {
		 * mapLive=ds.getAreaMediaTypeDayVd(areacode, "Live", sdate, edate);
		 * mapVod=ds.getAreaMediaTypeDayVd(areacode, "Vod", sdate, edate);
		 * mapBack=ds.getAreaMediaTypeDayVd(areacode, "Back", sdate, edate); }
		 * else if(dimension=="Rtg000") {
		 * mapLive=ds.getAreaMediaTypeDayVd(areacode, "Live", sdate, edate);
		 * mapVod=ds.getAreaMediaTypeDayVd(areacode, "Vod", sdate, edate);
		 * mapBack=ds.getAreaMediaTypeDayVd(areacode, "Back", sdate, edate);
		 * Integer durationLive=ds.getAreaMediaTypeDuration(areacode, "Live");
		 * Integer durationVod=ds.getAreaMediaTypeDuration(areacode, "Vod");
		 * Integer durationBack=ds.getAreaMediaTypeDuration(areacode, "Back");
		 * 
		 * mapLive = convertToRtg000(mapLive,durationLive); mapVod =
		 * convertToRtg000(mapVod,durationVod); mapBack =
		 * convertToRtg000(mapBack,durationBack);
		 * 
		 * } else if(dimension=="Rtg%") {
		 * mapLive=ds.getAreaMediaTypeDayVd(areacode, "Live", sdate, edate);
		 * mapVod=ds.getAreaMediaTypeDayVd(areacode, "Vod", sdate, edate);
		 * mapBack=ds.getAreaMediaTypeDayVd(areacode, "Back", sdate, edate);
		 * Integer durationLive=ds.getAreaMediaTypeDuration(areacode, "Live");
		 * Integer durationVod=ds.getAreaMediaTypeDuration(areacode, "Vod");
		 * Integer durationBack=ds.getAreaMediaTypeDuration(areacode, "Back");
		 * Integer userCount=Integer.parseInt(ds.getParam("userCount"));
		 * 
		 * mapLive = convertToRtg100(mapLive,durationLive,userCount); mapVod =
		 * convertToRtg100(mapVod,durationVod,userCount); mapBack =
		 * convertToRtg100(mapBack,durationBack,userCount);
		 * 
		 * } }
		 * 
		 * return toJson(mapLive,mapVod,mapBack);
		 */

	}

	private Map<String, Integer> convertToRtg100(Map<String, Integer> map,
			Integer duration, Integer userCount) {
		// TODO Auto-generated method stub
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue() / duration / userCount;
			result.put(key, value);
		}

		return result;
	}

	private Map<String, Integer> convertToRtg000(Map<String, Integer> map,
			Integer duration) {
		// TODO Auto-generated method stub
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue() / duration / 1000;
			result.put(key, value);
		}

		return result;
	}

	public Object toJson(Map<String, Integer> mapLive,
			Map<String, Integer> mapVod, Map<String, Integer> mapBack) {
		// TODO Auto-generated method stub

		List<DateRate> vodList = new ArrayList<DateRate>();

		for (Entry<String, Integer> entry : mapVod.entrySet()) {
			vodList.add(new DateRate(entry.getKey(), String.valueOf(entry
					.getValue())));
		}

		List<DateRate> liveList = new ArrayList<DateRate>();

		for (Entry<String, Integer> entry : mapLive.entrySet()) {
			liveList.add(new DateRate(entry.getKey(), String.valueOf(entry
					.getValue())));
		}

		List<DateRate> backList = new ArrayList<DateRate>();
		for (Entry<String, Integer> entry : mapBack.entrySet()) {
			backList.add(new DateRate(entry.getKey(), String.valueOf(entry
					.getValue())));
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ondemeand", vodList);
		jsonObject.put("live", liveList);
		jsonObject.put("lookback", backList);

		return jsonObject.toString();
	}

	@RequestMapping(value = "/getRanking", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object getRanking(String period, String dimension)
			throws IOException {

		List<Top3Rtg100> list = new ArrayList<Top3Rtg100>();
		list.add(new Top3Rtg100("program1", "3", "50"));
		list.add(new Top3Rtg100("program2", "2", "60"));
		list.add(new Top3Rtg100("program3", "1", "70"));

		JSONArray array = new JSONArray(list.toArray());

		return array.toString();

		/*
		 * DataStore ds=new MongoDataStore();
		 * 
		 * List<TopMeidaIndicator>
		 * result=ds.getTopMediaIndicator(period,dimension,3); List<Top3Rtg100>
		 * list=new ArrayList<Top3Rtg100>(); int i=1; for(TopMeidaIndicator
		 * indicator :result) { String
		 * programname=ds.getMediaName(indicator.getMedia_id
		 * (),indicator.getMedia_type());
		 * 
		 * list.add(new Top3Rtg100(programname, String.valueOf(i),
		 * indicator.getRtg100())); }
		 * 
		 * JSONArray array=new JSONArray(list.toArray());
		 * 
		 * return array.toString();
		 */

	}

	@RequestMapping(value = "/getPlayingTime", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object getPlayingTime(String period, String dimension)
			throws IOException {
		List<DayPlayTime> listVod = new ArrayList<DayPlayTime>();
		listVod.add(new DayPlayTime(DateTimeHelper.truncateToDay(new Date()),
				"1000"));
		listVod.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 1),
				"1100"));
		listVod.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 2),
				"1300"));
		listVod.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 3),
				"1500"));
		listVod.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 4),
				"1500"));
		listVod.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 5),
				"1700"));
		listVod.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 6),
				"1000"));

		List<DayPlayTime> listLive = new ArrayList<DayPlayTime>();
		listLive.add(new DayPlayTime(DateTimeHelper.truncateToDay(new Date()),
				"1000"));
		listLive.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 1),
				"100"));
		listLive.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 2),
				"300"));
		listLive.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 3),
				"500"));
		listLive.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 4),
				"500"));
		listLive.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 5),
				"700"));
		listLive.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 6),
				"000"));

		List<DayPlayTime> listBack = new ArrayList<DayPlayTime>();
		listBack.add(new DayPlayTime(DateTimeHelper.truncateToDay(new Date()),
				"1000"));
		listBack.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 1),
				"2100"));
		listBack.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 2),
				"2300"));
		listBack.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 3),
				"2500"));
		listBack.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 4),
				"2500"));
		listBack.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 5),
				"2700"));
		listBack.add(new DayPlayTime(DateTimeHelper.addDate(new Date(), 6),
				"2000"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("live", listLive);
		map.put("ondemeand", listVod);
		map.put("lookback", listBack);

		JSONObject json = new JSONObject(map);

		return json.toString();

	}

	@RequestMapping(value = "/getProgramRanking", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object getProgramRanking(String period, String dimension)
			throws IOException {
		List<MediaRanking> listVod = new ArrayList<MediaRanking>();
		List<MediaRanking> listLive = new ArrayList<MediaRanking>();
		List<MediaRanking> listBack = new ArrayList<MediaRanking>();
		List<MediaRanking> listAll = new ArrayList<MediaRanking>();
		// String programid, String program, String vv, String uv,
		// String vd, String users, String rankvalue, String rank

		for (int i = 0; i < 50; i++) {
			listVod.add(new MediaRanking(String.valueOf(i), "vodprogramName"
					+ i, "vod",String.valueOf(i * 1100), String.valueOf(i * 1000),
					String.valueOf(10000), String.valueOf(50000), "30%", String
							.valueOf(i)));
			listLive.add(new MediaRanking(String.valueOf(i), "liveprogramName"
					+ i, "live",String.valueOf(i * 1100), String.valueOf(i * 1000),
					String.valueOf(10000), String.valueOf(50000), "30%", String
							.valueOf(i)));
			listBack.add(new MediaRanking(String.valueOf(i), "backprogramName"
					+ i,"back", String.valueOf(i * 1100), String.valueOf(i * 1000),
					String.valueOf(10000), String.valueOf(50000), "30%", String
							.valueOf(i)));
			
			String[] actions=new String[]{"vod","live","back"};
			
			listAll.add(new MediaRanking(String.valueOf(i), "programName" + i,actions[rand.nextInt(2)],
					String.valueOf(i * 1100), String.valueOf(i * 1000), String
							.valueOf(10000), String.valueOf(50000), "30%",
					String.valueOf(i)));

		}

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("live", listLive);
		map.put("ondemeand", listVod);
		map.put("lookback", listBack);
		map.put("all", listAll);
		map.put("programnum", "50");
		map.put("users", "5000000");

		JSONObject json = new JSONObject(map);

		return json.toString();

	}

	@RequestMapping(value = "/getVisibilityDetail", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object getVisibilityDetail(String areacode, String sdate,
			String edate, String dateunit, String dimension) throws IOException {
		List<Map<String, String>> ls = new ArrayList<Map<String, String>>();

		for (int i = 0; i < 50; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("time", DateTimeHelper.addDate(new Date(), i));
			map.put("value", String.valueOf(10000 + rand.nextInt(1000)));
			ls.add(map);
		}

		JSONArray json = new JSONArray(ls.toArray());

		return json.toString();

	}

	@RequestMapping(value = "/getProgramInfo", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object getProgramInfo(String programId) throws IOException {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("programid", "programId");
		map.put("provider", "贵州广电");
		map.put("type", "直播");
		map.put("playtime", "2015-3-6");
		map.put("standard", "VD");
		map.put("targetaudience", "所有");

		JSONObject json = new JSONObject(map);

		return json.toString();

	}
	
	@RequestMapping(value = "/getProgramAnalysis", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object getProgramAnalysis(String areacode, String sdate, String edate,
			String dateunit, String dimension) throws IOException {
		List<Map<String, String>> ls = new ArrayList<Map<String, String>>();

		for (int i = 0; i < 50; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("date", DateTimeHelper.addDate(new Date(), i));
			map.put("value", String.valueOf(10000 + rand.nextInt(1000)));
			ls.add(map);
		}

		JSONArray json = new JSONArray(ls.toArray());

		return json.toString();

	}

}
