package longtv.dal;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

@Entity(value="unique_indicator", noClassnameStored=true)
public class UniqueIndicator {
	
	@Id ObjectId id;
	@Indexed private String media_id;
	private String media_type;
	private String area_code;
	private String times_slice_type;
	@Indexed private  String date_time;
	private String uv;
	private String v1;
	private String v2;
	private String v3;
	private String v4;
	private String v5;
	
	public ObjectId getId() {
		return id;
	}
	
	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getMedia_type() {
		return media_type;
	}
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}


	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getTimes_slice_type() {
		return times_slice_type;
	}
	public void setTimes_slice_type(String times_slice_type) {
		this.times_slice_type = times_slice_type;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public String getUv() {
		return uv;
	}
	public void setUv(String uv) {
		this.uv = uv;
	}
	public String getV1() {
		return v1;
	}
	public void setV1(String v1) {
		this.v1 = v1;
	}
	public String getV2() {
		return v2;
	}
	public void setV2(String v2) {
		this.v2 = v2;
	}
	public String getV3() {
		return v3;
	}
	public void setV3(String v3) {
		this.v3 = v3;
	}
	public String getV4() {
		return v4;
	}
	public void setV4(String v4) {
		this.v4 = v4;
	}
	public String getV5() {
		return v5;
	}
	public void setV5(String v5) {
		this.v5 = v5;
	}
	
}
