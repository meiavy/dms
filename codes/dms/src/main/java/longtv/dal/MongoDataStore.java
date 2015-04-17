package longtv.dal;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;

import longtv.controller.MyMongoClient;
import longtv.utils.DateTimeHelper;

public class MongoDataStore implements DataStore {

	private MongoClient mongoClient = MyMongoClient.getInstance();
	private Datastore dataStore;
	private Morphia morphia;

	public MongoDataStore() {
		// TODO Auto-generated constructor stub
		morphia = new Morphia();
		morphia.map(UniqueIndicator.class);
		morphia.map(Asset.class);
		morphia.map(VisitorIndicator.class);
		morphia.map(Area.class);
		morphia.map(Param.class);
		morphia.map(TopMeidaIndicator.class);
		morphia.map(BackLog.class);
		morphia.map(LiveLog.class);
		morphia.map(ShiftLog.class);
		morphia.map(VodLog.class);
		morphia.map(StartupLog.class);
		morphia.map(Terminal.class);
		morphia.map(EpgLog.class);
		dataStore = morphia.createDatastore(mongoClient, "dms");
	}
	
	



	@Override
	public int getMediaTypeReach000(String mediaType, String date) {
		// TODO Auto-generated method stub

		Query<UniqueIndicator> result = dataStore
				.find(UniqueIndicator.class, "date_time", date)
				.filter("media_type", mediaType)
				.filter("times_slice_type", "Day");

		int reach000 = 0;
		for (UniqueIndicator indicator : result) {
			System.out.println(indicator.getMedia_id());
			reach000 += Integer.parseInt(indicator.getUv());
		}

		return reach000 / 1000;
	}

	@Override
	public Map<String, Integer> getMediaTypeVisitorGroupByArea(
			String mediaType, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		Query<VisitorIndicator> result = dataStore
				.find(VisitorIndicator.class, "media_type", mediaType)
				.filter("date_time >=", DateTimeHelper.truncateToDay(startDate))
				.filter("date_time <=", DateTimeHelper.truncateToDay(endDate));

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (VisitorIndicator indicator : result) {
			System.out.println(indicator.getMedia_id());

			String areaCode = indicator.getArea_code();
			Integer visitor = (Integer) map.get(areaCode);
			if (visitor == null) {
				map.put(areaCode, Integer.parseInt(indicator.getVv()));
			} else {
				map.put(areaCode, visitor + Integer.parseInt(indicator.getVv()));
			}

		}

		return map;

	}

	@Override
	public String getAreaNameByCode(String areacode) {
		// TODO Auto-generated method stub

		Query<Area> result = dataStore.find(Area.class, "code", areacode);
		Area area = result.get();
		return area == null ? "" : area.getXian();

	}

	@Override
	public <T> void save(T indicator) {
		// TODO Auto-generated method stub
		dataStore.save(indicator);
	}

	@Override
	public Map<String, Integer> getAreaMediaTypeDayUv(String areacode,
			String mediaType, String start, String end) {
		// TODO Auto-generated method stub

		Query<UniqueIndicator> result = dataStore
				.find(UniqueIndicator.class, "media_type", mediaType)
				.filter("date_time >=", start)
				.filter("date_time <=", end)
				.filter("area_code", areacode).order("date_time");

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (UniqueIndicator indicator : result) {
			String key = indicator.getDate_time();
			Integer value = map.get(key);
			if (value == null) {
				map.put(indicator.getDate_time(),
						Integer.parseInt(indicator.getUv()));
			} else {
				map.put(indicator.getDate_time(),
						value + Integer.parseInt(indicator.getUv()));
			}

		}

		return map;

	}

	@Override
	public Map<String, Integer> getAreaMediaTypeDayVv(String areacode,
			String mediaType, String start, String end) {
		// TODO Auto-generated method stub

		Query<VisitorIndicator> result = dataStore
				.find(VisitorIndicator.class, "media_type", mediaType)
				.filter("date_time >=", start)
				.filter("date_time <=", DateTimeHelper.getTomorrow(DateTimeHelper.fromString(end,"yyyy-MM-dd")))
				.filter("area_code", areacode).order("date_time");

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (VisitorIndicator indicator : result) {
			
			String key = DateTimeHelper.truncateToDay(DateTimeHelper.fromString(indicator.getDate_time(), "yyyy-MM-dd HH"));
			
			Integer value = map.get(key);
			if (value == null) {
				map.put(indicator.getDate_time(),
						Integer.parseInt(indicator.getVv()));
			} else {
				map.put(indicator.getDate_time(),
						value + Integer.parseInt(indicator.getVv()));
			}

		}

		return map;

	}

	@Override
	public Map<String, Integer> getAreaMediaTypeDayVd(String areacode,
			String mediaType, String start, String end) {
		// TODO Auto-generated method stub
		Query<VisitorIndicator> result = dataStore
				.find(VisitorIndicator.class, "media_type", mediaType)
				.filter("date_time >=",start)
				.filter("date_time <=", DateTimeHelper.getTomorrow(DateTimeHelper.fromString(end,"yyyy-MM-dd")))
				.filter("area_code", areacode).order("date_time");

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (VisitorIndicator indicator : result) {
			
			String key = DateTimeHelper.truncateToDay(DateTimeHelper.fromString(indicator.getDate_time(), "yyyy-MM-dd HH"));
			
			Integer value = map.get(key);
			if (value == null) {
				map.put(indicator.getDate_time(),
						Integer.parseInt(indicator.getVd()));
			} else {
				map.put(indicator.getDate_time(),
						value + Integer.parseInt(indicator.getVd()));
			}

		}

		return map;
	}

	@Override
	public Integer getAreaMediaTypeDuration(String areacode, String mediaType) {
		// TODO Auto-generated method stub
		Query<Asset> result = dataStore
				.find(Asset.class, "media_type", mediaType)
				.filter("area_code", areacode);

		Integer ret=0;
		for (Asset indicator : result) {
			//ret+=Integer.parseInt((String) indicator.getProperties().get("media_duration"));
		}

		return ret;
	}

	@Override
	public String getParam(String string) {
		// TODO Auto-generated method stub
		Query<Param> result = dataStore
				.find(Param.class, "key", string);
		
		Param param=result.get();

		return param!=null?param.getValue():"0";
	}

	@Override
	public List<TopMeidaIndicator> getTopMediaIndicator(String period,
			String mediaType, int limit) {
		// TODO Auto-generated method stub
		
		Query<TopMeidaIndicator> result = dataStore
				.find(TopMeidaIndicator.class, "period", period);
		
		if(mediaType!=null)
		{
			result=result.filter("media_type", mediaType);
		}
		
		result=result.order("rtg100").limit(3);
		
		return result.asList();
	}

	@Override
	public String getMediaName(String media_id, String media_type) {
		// TODO Auto-generated method stub
		
		Query<Asset> result = dataStore
				.find(Asset.class, "media_type", media_type)
				.filter("media_id", media_id);
		
		Asset m=result.get();
		
		return m==null?"":m.getAsset_name();

	}

	@Override
	public List<Area> getArea() {
		// TODO Auto-generated method stub
		
		Query<Area> result = dataStore
				.find(Area.class);
		
		return result.asList();
	}





	@Override
	public Datastore getMorphiaDataStore() {
		// TODO Auto-generated method stub
		return dataStore;
	}




}
