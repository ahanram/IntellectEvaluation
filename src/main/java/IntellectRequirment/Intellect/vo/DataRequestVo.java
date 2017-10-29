package IntellectRequirment.Intellect.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ahan rAm
 *
 */
public class DataRequestVo {

	@JsonProperty("id")
	private String id;
	@JsonProperty("fName")
	private String fName;
	@JsonProperty("IName")
	private String iName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("pincode")
	private Number pincode;
	@JsonProperty("brithDate")
	private String brithDate;
	@JsonProperty("isActive")
	private Boolean isActive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Number getPincode() {
		return pincode;
	}

	public void setPincode(Number pincode) {
		this.pincode = pincode;
	}

	

	public String getBrithDate() {
		return brithDate;
	}

	public void setBrithDate(String brithDate) {
		this.brithDate = brithDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
