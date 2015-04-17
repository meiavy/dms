package longtv.vo;

public class AreaVisitor {
	
	private String areacode;
	private String areaname;
	private String visibility;
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public AreaVisitor(String areacode, String areaname, String visibility) {
		super();
		this.areacode = areacode;
		this.areaname = areaname;
		this.visibility = visibility;
	}
	
	
	
}
