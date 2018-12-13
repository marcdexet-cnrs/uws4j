package fr.ias.ivoa.uws4j.rest;

import static java.util.stream.Collectors.toList;

import java.util.List;

import fr.ias.ivoa.uws4j.UWS;
import fr.ias.ivoa.uws4j.domain.JobList;

public class JobListRepresentation {
	
	private String name;
	private String version;
	private List<JobRepresentation> jobs;
	
	
	public JobListRepresentation(JobList jobList) {
		this.name = jobList.getName();
		this.version = UWS.VERSION;
		this.jobs = jobList.getJobs().stream().map(JobRepresentation::from).collect(toList());
	}

	public static JobListRepresentation from(JobList jobList) {
		return new JobListRepresentation(jobList);
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public List<JobRepresentation> getJobs() {
		return jobs;
	}
	
	

}
