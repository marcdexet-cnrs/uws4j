package fr.ias.ivoa.uws4j.exceptions;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Representation for any exception with confidential details.<br>
 * It wraps the actual exception to be exposed to client, <br>
 * such as it make description harmless, <br>
 * associated an id <br> 
 * and a timestamp to make easy localization of exception into logs.<br>
 * The actual cause could be shown according to {@link #showCause} value.
 * @author mdexet
 *
 */
public class PublicFailureRepresentation {

	private UUID id;
	private String description;
	private Throwable cause;
	private boolean debug;

	/**
	 * 
	 * @param msg
	 * @param cause
	 * @param showCause if true, the actual cause would be shown.
	 */
	public PublicFailureRepresentation(String msg, Throwable cause, boolean showCause) {
		this.description = msg;
		this.id = UUID.randomUUID();
		this.cause = cause;
		this.debug = showCause;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getMessage() {
		return String.format("An error identified by %s occured at %s with following description :'%s'", id, LocalDateTime.now(), description);
	}
	
	public String getCause() {
		if ( debug ) {
			return cause.getMessage();
		}
		return null;
	}

}
