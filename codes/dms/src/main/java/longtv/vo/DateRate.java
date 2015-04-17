package longtv.vo;

public class DateRate {
	
	private String date;
	private String rateings;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRateings() {
		return rateings;
	}
	public void setRateings(String rateings) {
		this.rateings = rateings;
	}
	public DateRate(String date, String rateings) {
		super();
		this.date = date;
		this.rateings = rateings;
	}

}
