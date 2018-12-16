package fr.ias.ivoa.uws4j.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


/**
 *
 * @author mdexet
 *
 */
public class Job {
	
	private String jobId;
	private String runId;
	private String jobList;
	private String phase;
	private LocalDateTime creationTime;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private LocalDateTime destruction;
	private Error error;
	private Map<String, String> parameters;
	private List<Result> results;
	private List<PhaseTransition> transitions;
	private String owner;
	private Integer executionDuration;
	private LocalDateTime quote;
	
	public String getRunId() {
		return runId;
	}
	public void setRunId(String groupId) {
		this.runId = groupId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobList() {
		return jobList;
	}
	public void setJobList(String jobList) {
		this.jobList = jobList;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(LocalDateTime creationDate) {
		this.creationTime = creationDate;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startDate) {
		this.startTime = startDate;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public LocalDateTime getDestruction() {
		return destruction;
	}
	public void setDestruction(LocalDateTime destruction) {
		this.destruction = destruction;
	}
	public void setError(Error error) {
		this.error = error;
	}
	public Error getError() {
		return error;
	}
	public Map<String, String> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	public List<PhaseTransition> getTransitions() {
		return transitions;
	}
	public void setTransitions(List<PhaseTransition> transitions) {
		this.transitions = transitions;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getOwner() {	
		return owner;
	}
	public void setExecutionDuration(Integer executionDuration) {
		this.executionDuration = executionDuration;
	}
	
	public Integer getExecutionDuration() {
		return executionDuration;
	}
	public LocalDateTime getQuote() {
		return quote;
	}
	
	public void setQuote(LocalDateTime quote) {
		this.quote = quote;
	}
}
