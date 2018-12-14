package fr.ias.ivoa.uws4j.services;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import fr.ias.ivoa.uws4j.domain.Job;
import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.exceptions.NotFoundException;

@Component
public interface JobService {

	public Optional<JobList> findJobList(String name);
	
	public JobList getJobList(String name) throws NotFoundException;

	public void addJobToJobList(Job job, JobList jobList);

	public Job createJobFromParameters(Map<String, String> params);
		
	public Job getJob(String jobId, JobList jobList) throws NotFoundException;

}
