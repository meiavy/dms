package longtv.dal;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mongodb.morphia.Datastore;

public interface DataStore {

	int getMediaTypeReach000(String mediaType, String date);

	Map<String, Integer> getMediaTypeVisitorGroupByArea(String string,
			Date today, Date today2);

	String getAreaNameByCode(String areacode);

	<T> void save(T indicator);

	Map<String, Integer> getAreaMediaTypeDayUv(String areacode, String mediaType,
			String start, String end);

	Map<String, Integer> getAreaMediaTypeDayVv(String areacode, String mediaType,
			String start, String end);

	Map<String, Integer> getAreaMediaTypeDayVd(String areacode, String mediaType,
			String start, String end);

	Integer getAreaMediaTypeDuration(String areacode, String mediaType);

	String getParam(String string);

	List<TopMeidaIndicator> getTopMediaIndicator(String period,
			String mediaType, int limit);

	String getMediaName(String media_id, String media_type);

	List<Area> getArea();
	
	Datastore getMorphiaDataStore() ;

}
