package fr.ias.ivoa.uws4j.domain;

public class Error {
	
	private String type;
	private boolean detail;
	private String detailsHref;
	private String message;


	public String getDetailsHref() {
		return detailsHref;
	}
	
	public void setDetailsHref(String detailsHref) {
		this.detailsHref = detailsHref;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean hasDetail() {
		return detail;
	}
	
	public void setDetail(boolean detail) {
		this.detail = detail;
	}
}
