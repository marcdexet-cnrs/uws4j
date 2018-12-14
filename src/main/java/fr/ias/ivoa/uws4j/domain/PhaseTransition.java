package fr.ias.ivoa.uws4j.domain;

import java.time.LocalDateTime;

public class PhaseTransition {

	private String oldPhase;
	private String newPhase;
	private LocalDateTime time;
	
	public PhaseTransition() {
	}
	

	public PhaseTransition(String oldPhase, String newPhase) {
		this(oldPhase, newPhase, LocalDateTime.now());
	}

	public PhaseTransition(String oldPhase, String newPhase, LocalDateTime time) {
		super();
		this.oldPhase = oldPhase;
		this.newPhase = newPhase;
		this.time = time;
	}
	
	public String getOldPhase() {
		return oldPhase;
	}
	public void setOldPhase(String oldPhase) {
		this.oldPhase = oldPhase;
	}
	public String getNewPhase() {
		return newPhase;
	}
	public void setNewPhase(String newPhase) {
		this.newPhase = newPhase;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "PhaseTransition [oldPhase=" + oldPhase + ", newPhase=" + newPhase + ", time=" + time + "]";
	}
	
	
	
	
	
}
