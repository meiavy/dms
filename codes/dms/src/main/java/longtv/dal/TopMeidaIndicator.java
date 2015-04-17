package longtv.dal;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;


@Entity(value="top_media_indicator", noClassnameStored=true)
public class TopMeidaIndicator {
	
	@Id ObjectId id;
	@Indexed private String media_id;
	private String media_type;
	private String area_code;
	private String period;
	
	
	private String vv;
	private String uv;
	private String vd;
	private String rtg000;
	private String rtg100;
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
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getVv() {
		return vv;
	}
	public void setVv(String vv) {
		this.vv = vv;
	}
	public String getUv() {
		return uv;
	}
	public void setUv(String uv) {
		this.uv = uv;
	}
	public String getVd() {
		return vd;
	}
	public void setVd(String vd) {
		this.vd = vd;
	}
	public String getRtg000() {
		return rtg000;
	}
	public void setRtg000(String rtg000) {
		this.rtg000 = rtg000;
	}
	public String getRtg100() {
		return rtg100;
	}
	public void setRtg100(String rtg100) {
		this.rtg100 = rtg100;
	}
	
	
	
	
}
