package fr.ias.ivoa.uws4j.domain;
/**
 * 
 * @author mdexet
 */
public class Result {
	
	private String id;
	private String href;
	private String type;
	private String mimeType;
	private boolean redirection;
	private Long size;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isRedirection() {
		return redirection;
	}
	public void setRedirection(boolean redirection) {
		this.redirection = redirection;
	}
	
	public String getMimeType() {
		return mimeType;
	}
	
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public Long getSize() {
		return this.size;
	}	
	public void setSize(Long size) {
		this.size = size;
	}

}
