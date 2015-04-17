package longtv.vo;

public class DayPlayTime {
	private String date;
	private String palyingtime;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPalyingtime() {
		return palyingtime;
	}
	public void setPalyingtime(String palyingtime) {
		this.palyingtime = palyingtime;
	}
	public DayPlayTime(String date, String palyingtime) {
		super();
		this.date = date;
		this.palyingtime = palyingtime;
	}
	
}

