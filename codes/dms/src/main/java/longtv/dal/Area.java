package longtv.dal;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value="area", noClassnameStored=true)
public class Area {
	
	@Id ObjectId id;
	private String sheng;
	private String shi;
	private String xian;
	private String jingdu;
	private String weidu;
	private List<String> area_code;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getSheng() {
		return sheng;
	}
	public void setSheng(String sheng) {
		this.sheng = sheng;
	}
	public String getShi() {
		return shi;
	}
	public void setShi(String shi) {
		this.shi = shi;
	}
	public String getXian() {
		return xian;
	}
	public void setXian(String xian) {
		this.xian = xian;
	}
	public String getJingdu() {
		return jingdu;
	}
	public void setJingdu(String jingdu) {
		this.jingdu = jingdu;
	}
	public String getWeidu() {
		return weidu;
	}
	public void setWeidu(String weidu) {
		this.weidu = weidu;
	}
	public List<String> getArea_code() {
		return area_code;
	}
	public void setArea_code(List<String> area_code) {
		this.area_code = area_code;
	}


}
