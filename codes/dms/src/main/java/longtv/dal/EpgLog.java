package longtv.dal;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value="epg_log", noClassnameStored=true)
public class EpgLog {
	@Id ObjectId id;
	private String on_id;
	private String ts_id;
	private String channel_id;
	private String date_time;
	private String program_name;
	public String getOn_id() {
		return on_id;
	}
	public void setOn_id(String on_id) {
		this.on_id = on_id;
	}
	public String getTs_id() {
		return ts_id;
	}
	public void setTs_id(String ts_id) {
		this.ts_id = ts_id;
	}
	public String getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public String getProgram_name() {
		return program_name;
	}
	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}
	
	
	
	
}
