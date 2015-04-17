package longtv.vo;

public class MediaRanking {

	 private String programid;
	 private String program;
	 private String action;
	 private String vv;
	 private String uv;
	 private String vd;
	 private String users;
	 private String rankvalue;
	 private String rank;
	public String getProgramid() {
		return programid;
	}
	public void setProgramid(String programid) {
		this.programid = programid;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
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
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public String getRankvalue() {
		return rankvalue;
	}
	public void setRankvalue(String rankvalue) {
		this.rankvalue = rankvalue;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public MediaRanking(String programid, String program, String action,String vv, String uv,
			String vd, String users, String rankvalue, String rank) {
		super();
		this.programid = programid;
		this.program = program;
		this.action=action;
		this.vv = vv;
		this.uv = uv;
		this.vd = vd;
		this.users = users;
		this.rankvalue = rankvalue;
		this.rank = rank;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
	 
}
