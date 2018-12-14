package fr.ias.ivoa.uws4j.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import fr.ias.ivoa.uws4j.UWS;

public class JobList {

	private String name;
	
	private Map<String, Job> jobById = new HashMap<>();
	
	
	public JobList(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public List<Job> getJobs() {
		return new ArrayList<>(jobById.values());
	}

	public String getVersion() {
		return UWS.VERSION;
	}

	public void addJob(Job job) {
		if ( job.getJobId() == null ) {
			String jobId  = UUID.randomUUID().toString();
			job.setJobId(jobId);
		}
		jobById.put(job.getJobId(), job);
	}
}
