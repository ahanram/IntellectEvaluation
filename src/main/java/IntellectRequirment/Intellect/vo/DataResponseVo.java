package IntellectRequirment.Intellect.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ahan Ram
 *
 */
public class DataResponseVo {

	@JsonProperty("restMsg")
	private String restMsg;
	@JsonProperty("userId")
	private String userId;
	@JsonProperty("valErrors")
	private String valErrors;
	public String getRestMsg() {
		return restMsg;
	}
	public void setRestMsg(String restMsg) {
		this.restMsg = restMsg;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getValErrors() {
		return valErrors;
	}
	public void setValErrors(String valErrors) {
		this.valErrors = valErrors;
	}
	
	
	}
