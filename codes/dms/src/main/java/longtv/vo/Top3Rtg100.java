package longtv.vo;

public class Top3Rtg100 {

    private String programname;
    private String ratingsindex;
    private String ratings;
	public String getProgramname() {
		return programname;
	}
	public void setProgramname(String programname) {
		this.programname = programname;
	}
	public String getRatingsindex() {
		return ratingsindex;
	}
	public void setRatingsindex(String ratingsindex) {
		this.ratingsindex = ratingsindex;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public Top3Rtg100(String programname, String ratingsindex, String ratings) {
		super();
		this.programname = programname;
		this.ratingsindex = ratingsindex;
		this.ratings = ratings;
	}
    
    
	
}
