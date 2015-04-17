package longtv.dal;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

@Entity(value="asset", noClassnameStored=true)
public class Asset {
	
	@Id ObjectId id;
	@Indexed private String asset_id;
	@Indexed private String asset_name;
	private String asset_provider;
	private Long asset_duration;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(String asset_id) {
		this.asset_id = asset_id;
	}
	public String getAsset_name() {
		return asset_name;
	}
	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}
	public String getAsset_provider() {
		return asset_provider;
	}
	public void setAsset_provider(String asset_provider) {
		this.asset_provider = asset_provider;
	}
	public Long getAsset_duration() {
		return asset_duration;
	}
	public void setAsset_duration(Long asset_duration) {
		this.asset_duration = asset_duration;
	}
	
	
	

}
